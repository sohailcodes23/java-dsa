package learnandpractice.stackAndQueue;

import learnandpractice.linkedlist.Node;
import util.CommonUtility;


//LIFO
public class StackWithLL {

    private static Node rear = null;
    private static Node head = null;
    private int count = 0;

    public static void main(String[] args) {
        StackWithLL stack = new StackWithLL();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        CommonUtility.traverseAndPrintLL(head);

        System.out.println("TOP 1 : " + stack.top());
        System.out.println("SIZE 1 : " + stack.size());

        stack.pop();

        System.out.println("AFTER POP SIZE 2 : " + stack.size());
        CommonUtility.traverseAndPrintLL(head);

        System.out.println("TOP 2 : " + stack.top());

        stack.push(7);
        CommonUtility.traverseAndPrintLL(head);

        System.out.println("SIZE 3 : " + stack.size());
    }

    //LIFO
    private void push(int val) {

        // adding at head, bcz STACK always adds at top of everyone, which will be new head
        Node newNode = new Node(val);
        newNode.next = head;// adding new node as head
        head = newNode;
        count++;
        if (rear == null) {
            rear = newNode;
        }
    }


    private int pop() {// basically removing head
        // STACK removes the last ele
        if (head == null) {
            System.out.println("EMPTY");
            return -1;
        }
        int val = head.data;
        head = head.next;
        count--;
        if (head == null) {// resetting
            rear = null;
        }
        return val;
    }


    private int top() {

        if (head == null) {
            System.out.println("EMPTY");
            return -1;
        }

        return head.data;
    }

    private int size() {
        return count;
    }
}
