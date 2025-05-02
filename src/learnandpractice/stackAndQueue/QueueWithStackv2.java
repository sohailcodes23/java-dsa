package learnandpractice.stackAndQueue;

import java.util.Stack;

// push operation was costlier in approach 1, so here we are adding TC in pop and top to keep push TC constant
public class QueueWithStackv2 {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public static void main(String[] args) {
        QueueWithStackv2 stack = new QueueWithStackv2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());   // 1
        System.out.println(stack.remove());   // 1
        System.out.println(stack.top());   // 2
    }


    public void push(int val) {
        st.add(val);
    }


    public int remove() {
        if (!temp.isEmpty()) {// if temp has variable those are already sorted for FIFO
            return temp.pop();
        } else {
            //moving to temp to get the FIFO using stack
            while (st.size() > 0) {
                temp.add(st.pop());
            }
            return temp.pop();
        }
    }

    public int top() {
        if (!temp.isEmpty()) {// if temp has variable those are already sorted for FIFO
            return temp.peek();
        } else {
            //moving to temp to get the FIFO using stack
            while (st.size() > 0) {
                temp.add(st.pop());
            }
            return temp.peek();
        }
    }
}
