package learnandpractice.linkedlist;

import util.CommonUtility;

/// IMP: Always update both next and back
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
        head = deletionOfTail(head);
//        deletionOfKthElement(head, 6);
//        deletionOfValue(head, 7);


        CommonUtility.traverseAndPrintDLL(head);

    }

    static DNode deletionOfHead(DNode head) {
//        DNode temp = head;
        head = head.next;///MIS Note which would be at left or right, if we want to overide we will pass the next value to the head
        head.back = null;// if we want to update the value of the current node, we will keep the value at right

        return head;
    }

    static DNode deletionOfTail(DNode head) {

        DNode secondLastNode = head;

        while (secondLastNode.next.next != null) {// this will go thill 2nd last node
            secondLastNode = secondLastNode.next;
        }
        DNode lastNode = secondLastNode.next;
        secondLastNode.next = null;// delete the last node
        lastNode.back = null;// IMP if not done, it would still be liknked with back
        return head;
    }

    static DNode deletionOfKthElement(DNode head, int k) { //k = index of 1
        DNode temp = head;

        return head;
    }

    static DNode deletionOfValue(DNode head, int k) {
        DNode temp = head;

        return head;
    }


}
