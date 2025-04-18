package learnandpractice.linkedlist;

import util.CommonUtility;

public class InsertionOfDNodeInDLL {

    public static void main(String[] args) {
//        int a[] = {1};
//        int a[] = {1, 2};
//        int a[] = {1, 2, 3, 4};
//        int a[] = {1, 2, 3, 4, 5, 6};
        int a[] = {4, 2, 1, 54, 6};
        DNode head = CommonUtility.convertArrayToDLL(a);
        if (head == null) {// if there is no head, like when array is empty
            return;
        }

//        head = insertionOfNodeBeforeHead(head, 9);
//        head = insertionOfNodeBeforeTail(head, 9);
//        head = insertionOfNodeBeforeKthElement(head, 9, 5);
//        head = insertionOfNodeBeforeDNodeBeforeValue(head, 9, 4);
        head = insertionOfNodeAtTheEndOfDLL(head, 9);


        CommonUtility.traverseAndPrintDLL(head);
    }

    static DNode insertionOfNodeBeforeHead(DNode head, int a) {
        DNode newHead = new DNode(a);

        newHead.next = head;
        head.prev = newHead;


        return newHead;
    }

    static DNode insertionOfNodeBeforeTail(DNode head, int a) {
        DNode newTail = new DNode(a);
        DNode temp = head;
        //Edge case
        if (temp.next == null) {// temp is at head and no other element in DLL
            return insertionOfNodeBeforeHead(head, a);
        }

        // 1 2 3 4
        while (temp.next.next != null) {// 2nd last node
            temp = temp.next;
        }
        // Here temp is 2nd last
        DNode lastNode = temp.next;// last node
        // Draw for better understanding
        temp.next = newTail;
        newTail.next = lastNode;

        lastNode.prev = newTail;
        newTail.prev = temp;
        return head;
    }

    static DNode insertionOfNodeBeforeKthElement(DNode head, int a, int k) { //k = index of 1

        DNode newDNode = new DNode(a);
        DNode temp = head;

        int count = 0;
        while (temp != null) {
            count++;
            if (count > k) {
                System.out.println("INSERTION NOT POSSIBLE");
                return head;
            }
            if (count == k) {
                DNode prevKNode = temp.prev;
                DNode frontKNode = temp;
                if (prevKNode == null) {//prev of k is null so temp is head : k=1
                    return insertionOfNodeBeforeHead(head, a);
                } else {// handle tail condition as well
                    prevKNode.next = newDNode;
                    newDNode.next = frontKNode;

                    frontKNode.prev = newDNode;
                    newDNode.prev = prevKNode;
                }
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    static DNode insertionOfNodeBeforeDNodeBeforeValue(DNode head, int a, int kValue) {
        DNode newDNode = new DNode(a);
        DNode temp = head;

        while (temp != null) {
            int value = temp.data;
            if (value == kValue) {
                DNode prevKNode = temp.prev;
                DNode frontKNode = temp;
                if (prevKNode == null) {//prev of kValue is null so temp is head : kValue=1
                    return insertionOfNodeBeforeHead(head, a);
                } else {// handle tail condition as well
                    prevKNode.next = newDNode;
                    newDNode.next = frontKNode;

                    frontKNode.prev = newDNode;
                    newDNode.prev = prevKNode;
                }
                return head;
            }
            temp = temp.next;
        }
        return head;
    }


    public static DNode insertionOfNodeAtTheEndOfDLL(DNode head, int a) {
        DNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        DNode newTail = new DNode(a);

        temp.next = newTail;
        newTail.prev = temp;
        newTail.next = null;// be default will be null

        return head;
    }

}
