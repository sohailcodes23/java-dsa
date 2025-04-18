package learnandpractice.linkedlist;

import util.CommonUtility;

/// IMP: Always update both next and prev
public class DeletionOfNodeInDLL {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
//        int a[] = {1, 2, 3, 4, 5, 6};
//        int a[] = {4, 2, 1, 54, 6};
        DNode head = CommonUtility.convertArrayToDLL(a);
        if (head == null) {// if there is no head, like when array is empty
            return;
        }
//        head = deletionOfHead(head);
//        head = deletionOfTail(head);
//        head = deletionOfKthElement(head, 1);
        head = deletionOfValue(head, 1);


        CommonUtility.traverseAndPrintDLL(head);

    }

    static DNode deletionOfHead(DNode head) {
//        DNode temp = head;
        head = head.next;///MIS Note which would be at left or right, if we want to overide we will pass the next value to the head
        head.prev = null;// if we want to update the value of the current node, we will keep the value at right

        return head;
    }

    static DNode deletionOfTail(DNode head) {

        DNode secondLastNode = head;

        while (secondLastNode.next.next != null) {// this will go thill 2nd last node
            secondLastNode = secondLastNode.next;
        }
        DNode lastNode = secondLastNode.next;
        secondLastNode.next = null;// delete the last node
        lastNode.prev = null;// IMP if not done, it would still be linked with prev
        return head;
    }

    static DNode deletionOfKthElement(DNode head, int k) { //k = index of 1
        DNode temp = head;
        int count = 0;
        while (temp != null) {

            count++;
            if (count > k) {//kth element is not present in LL
                break;
            }
            if (count == k) {
                DNode frontOfKNode = temp.next;
                DNode prevOfKNode = temp.prev;

                //EDGE cases
                if (prevOfKNode == null && frontOfKNode == null) {// that means it's a single node DLL
                    head = null;// delete the single node
                    return null;
                } else if (prevOfKNode == null) {// if only prev is nul, than temp is the  head of DLL
                    head = head.next;// moved the head
                    head.prev = null;//delink the prev as nulll of new head
                    break;// OR return head
                } else if (frontOfKNode == null) {//if front is null temp is at tail of DLL
                    temp.prev = null;
                    prevOfKNode.next = null;// unlink the temp(tail)
                    break;// OR return head
                }

                //Normal case
                prevOfKNode.next = frontOfKNode;//prev next is connecting with front of K
                frontOfKNode.prev = prevOfKNode;//front prev is connecting with prev of K
                //IMP need to update current temp so that it is removed from memory
                temp.next = null;
                temp.prev = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // head can never be the value
    static DNode deletionOfValue(DNode head, int k) {
        DNode temp = head;
        while (temp != null) {
            int value = temp.data;
            if (value == k) {
                DNode frontOfKNode = temp.next;
                DNode prevOfKNode = temp.prev;

                //EDGE cases
                if (prevOfKNode == null && frontOfKNode == null) {// that means it's a single node DLL
                    head = null;// delete the single node
                    return null;
                } else if (prevOfKNode == null) {// if only prev is nul, than temp is the  head of DLL
                    head = head.next;// moved the head
                    head.prev = null;//delink the prev as nulll of new head
                    break;// OR return head
                } else if (frontOfKNode == null) {//if front is null temp is at tail of DLL
                    temp.prev = null;
                    prevOfKNode.next = null;// unlink the temp(tail)
                    break;// OR return head
                }

                //Normal case
                prevOfKNode.next = frontOfKNode;//prev next is connecting with front of K
                frontOfKNode.prev = prevOfKNode;//front prev is connecting with prev of K
                //IMP need to update current temp so that it is removed from memory
                temp.next = null;
                temp.prev = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


}
