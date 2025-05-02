package learnandpractice.stackAndQueue;

import java.util.Stack;

// Queue using 2 stacks - Costly push (O(n)), Fast pop/top (O(1))
// This is suitable if pop/top are called frequently, and push is rare
// Here push operation will take a lot of time, so if limited push this is fine, but if lots of push, we can add the TC on top and pop and make push easier
public class QueueWithStackv1 {
    // 3steps
    // st  --> temp
    // ele --> st
    // temp--> st
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public static void main(String[] args) {
        QueueWithStackv1 stack = new QueueWithStackv1();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());   // 1
        System.out.println(stack.remove());   // 1
        System.out.println(stack.top());   // 2
    }

    // Costly push to maintain FIFO order
    public void push(int val) {
//        3 steps for Queue with Stack
        // move everything from st to temp
        while (st.size() > 0) {
            temp.add(st.pop());// pop to add and remove from the stack
        }

        // add ele in st
        st.add(val);

        // move from temp to st
        while (temp.size() > 0) {
            st.add(temp.pop());// pop to add and remove from the stack
        }
    }


    public int remove() {
        if (st.isEmpty()) throw new RuntimeException("Queue is empty");
        return st.pop(); // removes front, which is the top of the simulated Queue
    }

    public int top() {
        if (st.isEmpty()) throw new RuntimeException("Queue is empty");
        return st.peek(); // peek front, which is the top
    }
}
