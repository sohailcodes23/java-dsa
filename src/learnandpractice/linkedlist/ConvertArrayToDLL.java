package learnandpractice.linkedlist;

import util.CommonUtility;

//ConvertArrayToDoublyLL
public class ConvertArrayToDLL {

    public static void main(String[] args) {

        int a[] = {4, 2, 1, 54, 6};
        DNode head = convertArrayToDLL(a);

    }


    static DNode convertArrayToDLL(int a[]) {
        DNode head = new DNode(a[0]);
        DNode prev = head;

        for (int i = 1; i < a.length; i++) {// i=1 so it will assign next element of prev/head
            DNode nxtTemp = new DNode(a[i]);
            nxtTemp.back = prev;// linking back to prev
            prev.next = nxtTemp;// linking prev to nxtTemp(front)
            // Now there is 2 way communication between DNode

            //We need to move prev to next for the upcoming nodes
            prev = nxtTemp;
        }

        CommonUtility.traverseAndPrintDLL(head);
        return head;
    }

    static int searchAElement(DNode head, int target) {
        DNode traverseDNode = head;
        while (traverseDNode != null) {
            if (traverseDNode.data == target) {
                return target;
            }
            traverseDNode = traverseDNode.next;
        }

        return -1;
    }

}

