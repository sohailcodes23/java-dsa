package learnandpractice.stackAndQueue;

//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Stack;

// } Driver Code Ends
class NextLargerElement_Pattern {

    public static void main(String[] args) {
//        int a[] = {6, 8, 0, 1, 3};//8 -1 1 3 -1
        int a[] = {4, 5, 2, 10};//8 -1 1 3 -1
//        System.out.println(nextLargerElement(a));
//        System.out.println(Arrays.toString(nextLargerElementv2(a)));
        System.out.println(nextLargerElementv3(a));
    }

    public static int[] nextGreaterRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static int[] nextLargerElementv2(int[] arr) {
//       TC==> O(2N) ==> O(N)
//       SC==> O(2N) ==> O(N)
        int n = arr.length;
        int res[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            int ele = st.isEmpty() ? -1 : st.peek();
            res[i] = ele;
            st.add(arr[i]);// always add the current index in stack
        }

        return res;
    }

    public static ArrayList<Integer> nextLargerElementv3(int[] arr) {
//       TC==> O(2N) ==> O(N)
//       SC==> O(2N) ==> O(N)
        int n = arr.length;
//        int res[] = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        // Set default values as -1
        for (int i = 0; i < n; i++) {
            ans.add(-1);
        }
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            int ele = st.isEmpty() ? -1 : st.peek();
            ans.set(i, ele);
            st.add(arr[i]);// always add the current index in stack
        }
        return ans;
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
//       TC==> O(2N) ==> O(N)
//       SC==> O(2N) ==> O(N)
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        // Set default values as -1
        for (int i = 0; i < n; i++) {
            ans.add(-1);
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // If curr Ele > last peek ele, add that in ans
            if (!st.isEmpty()) {
                int lastPeek = st.peek();
                //The while loop inside the for loop does not make this O(N²) because each index is processed once for push and once for pop.
                while (!st.isEmpty() && arr[i] > arr[lastPeek]) {
                    ans.set(lastPeek, arr[i]);
                    st.pop();// last peek is not needed so remove it
                }
            }

            st.add(i);// always add the current index in stack
        }

        return ans;
    }
}
