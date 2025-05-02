package learnandpractice.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());   // 3
        System.out.println(stack.pop());   // 3
        System.out.println(stack.top());   // 2
    }

    public void push(int val) {

        // adding last bcz STACK always adds at last
        q.add(val);
        int size = q.size();
        // Rotate the queue to bring the newly added element to the front
        //Even though we're using a FIFO queue, by rotating after every push,
        // we rebuild the queue so the newest element is always at the front, giving us LIFO behavior.
        while (size > 1) {// leaving the last element as it is(most recently added) // rotate the element
            int front = q.remove();
            q.add(front);// add the front element at the last
            size--;
//            EX: 1 added no rotation
//            EX: 2 added Before: 1,2    After: 2,1
//            EX: 3 added Before: 2,1,3    After: 1,3,2 == 3,2,1
//            EX: 4 added Before: 3,2,1,4    After: 3,2,1,4 == 2,1,4,3 == 1,4,3,2 == 4,3,2,1
        }
    }


    public int pop() {
        if (q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.remove(); // removes front, which is the top of the simulated stack
    }

    public int top() {
        if (q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.peek(); // peek front, which is the top
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
