package learnandpractice.stackAndQueue;

import learnandpractice.linkedlist.Node;
import util.CommonUtility;


//FIFO
public class QueueWithLL {

    private static Node rear = null;
    private static Node head = null;
    private int count = 0;

    public static void main(String[] args) {
        QueueWithLL stack = new QueueWithLL();
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

    //FIFO
    private void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = rear = newNode;
        } else {// adding at last
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }


    private int pop() {// basically removing head
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
