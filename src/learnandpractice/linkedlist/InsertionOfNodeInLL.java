package learnandpractice.linkedlist;

public class InsertionOfNodeInLL {

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
//        int a[] = {1, 2, 3, 4, 5, 6};
//        int a[] = {4, 2, 1, 54, 6};
        Node head = convertArrayToLL(a);
        if (head == null) {// if there is no head, like when array is empty
            return;
        }

//        insertionOfHead(head, 9);
//        insertionOfTail(head, 9);
//        insertionOfKthElement(head, 9, 1);
        insertionOfNodeBeforeValue(head, 9, 3);

    }

    static Node insertionOfHead(Node head, int a) {
        Node newHead = new Node(a);
        newHead.next = head;

        traverseAndPrintLL(newHead);

        return head;
    }

    static Node insertionOfTail(Node head, int a) {
        Node newTail = new Node(a);
        Node temp = head;

        while (temp.next != null) {// head.next is null that means we are at last node
            temp = temp.next;
        }
        temp.next = newTail;// setting new tail at last node
        traverseAndPrintLL(head);

        return head;
    }

    static Node insertionOfKthElement(Node head, int a, int k) { //k = index of 1
        // this only work till LL size + 1 position
        Node newNode = new Node(a);
        Node temp = head;
        if (k == 1 || temp == null) {// insert at head
            newNode.next = head;
            traverseAndPrintLL(newNode);
            return newNode;
        }
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k - 1) {//that mean we have to insert at the next position, so if kwas 3, and we are at 2, we want to insert at 3
                newNode.next = temp.next;// first linking the newNode to the current kth node, if we don't do this we will lose the reference
                temp.next = newNode;// than connect temp to the newNode, this is the correct position
                break;// bcz we have already inserted
            }
            temp = temp.next;
        }
        if (temp == null) {// this means we want to add element at more than allowed position
            System.out.println("NOT POSSIBLE");
        }
        traverseAndPrintLL(head);

        return head;
    }

    static Node insertionOfNodeBeforeValue(Node head, int a, int value) {
        // this only work till LL size + 1 position
        Node newNode = new Node(a);
        Node temp = head;
        if (head.data == value) {
            newNode.next = head;
            traverseAndPrintLL(newNode);
            return newNode;
        }

        while (temp != null && temp.next != null) {// checking temp.next so that we can check that next data is present
//            count++;
            if (temp.next.data == value) {//that mean we need to insert before the next element
                newNode.next = temp.next;// first linking the newNode to the current kth node, if we don't do this we will lose the reference
                temp.next = newNode;// than connect temp to the newNode, this is the correct position
                break;// bcz we have already inserted
            }
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
