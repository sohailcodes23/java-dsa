package learnandpractice.linkedlist;

import util.CommonUtility;

public class ReverseADLL {

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
//        int a[] = {1, 2, 3, 4, 5, 6};
//        int a[] = {4, 2, 1, 54, 6};
        DNode head = CommonUtility.convertArrayToDLL(a);
        if (head == null) {// if there is no head, like when array is empty
            return;
        }

        head = reverse(head);

        CommonUtility.traverseAndPrintDLL(head);
    }

    public static DNode reverse(DNode head) {
//TC==> O(N)
        if (head == null || head.next == null) {// single element or null Node
            return head;
        }
        DNode current = head;
        DNode prevNode = null;
        DNode frontNode;
        while (current != null) {
            prevNode = current.prev;
            frontNode = current.next;

            // swapping the linking with prev and front
            current.prev = frontNode;
            current.next = prevNode;

            current = current.prev;// since the linking is swapped used back/prev to move forward
        }
        // Here current is null and prev is at the 2nd last
        head = prevNode.prev;// since prev is at 2nd last element and prev.back is pointing to the new head

        return head;
    }
}
