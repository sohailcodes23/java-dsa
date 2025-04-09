package learnandpractice.linkedlist;

public class DeletionOfNodeInLL {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
//        int a[] = {4, 2, 1, 54, 6};
        Node head = convertArrayToLL(a);
        if (head == null) {// if there is no head, like when array is empty
            return;
        }
//        deletionOfHead(head);
//        deletionOfTail(head);
//        deletionOfKthElement(head, 6);
        deletionOfValue(head, 7);
    }

    static Node deletionOfHead(Node head) {
        head = head.next;// this basically assigned the head to the next node, so it automatically deleted head
        //Original head will be deleted by garbage collector

        traverseAndPrintLL(head);

        return head;
    }

    static Node deletionOfTail(Node head) {

        Node temp = head;

        while (temp.next.next != null) {// head.next.next is null that means we are at 2nd last element and if we set null after this the last element will be deleted
            temp = temp.next;
        }
        //currently temp at 2nd last element, so next element will be last
        temp.next = null;// deleting last element, by setting it as null
        traverseAndPrintLL(head);

        return head;
    }

    static Node deletionOfKthElement(Node head, int k) { //k = index of 1
        Node temp = head;
        if (k == 1) {
            head = head.next;
            return head;
        }
        Node prev = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count > k) {//kth element is not present in LL
                break;
            }
            if (count == k) {// this also handle tail deletion since previous.next.next is by default null in tail deletion condition
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        traverseAndPrintLL(head);

        return head;
    }

    static Node deletionOfValue(Node head, int k) {
        Node temp = head;
        if (k == 1) {
            head = head.next;
            return head;
        }
        Node prev = head;
        while (temp != null) {
            if (temp.data == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        traverseAndPrintLL(head);

        return head;
    }


    public static void traverseAndPrintLL(Node head) {
        System.out.println("Whole LINKED LIST: ");
        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.data);
            traverseNode = traverseNode.next;
        }
    }


    static Node convertArrayToLL(int a[]) {
        Node head = new Node(a[0]);
        Node mover = head;// Created another node for logic bcz we always try to avoid updating head
        // If head is updated we will forget the starting point of the LL

        for (int i = 1; i < a.length; i++) {
            Node temp = new Node(a[i]);
            mover.next = temp;// linking mover to the next element, but after this we need to move mover to next node to link it to next node(elements)
            mover = temp;//move mover to next node(temp) place, in next loop temp will be at next index and we can keep moving mover after linking it to temp
        }

        return head;
    }

}
