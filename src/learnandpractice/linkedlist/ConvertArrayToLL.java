package learnandpractice.linkedlist;

public class ConvertArrayToLL {

    public static void main(String[] args) {

        int a[] = {4, 2, 1, 54, 6};
        Node head = convertArrayToLLv2(a);
        System.out.println("SEARCHED " + searchAElement(head, 6));
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

    static Node convertArrayToLLv2(int a[]) {
        Node head = new Node(a[0]);
        Node mover = head;// Created another node for logic bcz we always try to avoid updating head
        // If head is updated we will forget the starting point of the LL

        for (int i = 1; i < a.length; i++) {
            Node temp = new Node(a[i]);
            mover.next = temp;// linking mover to the next element, but after this we need to move mover to next node to link it to next node(elements)
            mover = temp;//move mover to next node(temp) place, in next loop temp will be at next index and we can keep moving mover after linking it to temp
        }

        // Traverse the LL
        Node traverseNode = head;
        int count = 0;// Size of LL
        while (traverseNode != null) {
            System.out.println(traverseNode.data);
            traverseNode = traverseNode.next;
            count++;
        }
        System.out.println("COUNT " + count);
        return head;
    }

    static int searchAElement(Node head, int target) {
        Node traverseNode = head;
        while (traverseNode != null) {
            if (traverseNode.data == target) {
                return target;
            }
            traverseNode = traverseNode.next;
        }

        return -1;
    }

}

