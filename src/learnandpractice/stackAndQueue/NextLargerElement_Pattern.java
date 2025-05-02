package learnandpractice.stackAndQueue;

//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Stack;

// } Driver Code Ends
class NextLargerElement_Pattern {

    public static void main(String[] args) {
        int a[] = {6, 8, 0, 1, 3};//8 -1 1 3 -1
        System.out.println(nextLargerElement(a));
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
