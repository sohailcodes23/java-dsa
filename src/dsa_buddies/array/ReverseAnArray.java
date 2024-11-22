package dsa_buddies.array;

//https://leetcode.com/problems/reverse-string/solutions/6053158/0-ms-runtime-beats-100-user-confirm-step-by-steps-solution-beginner-friendly/
public class ReverseAnArray {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        int[] arr = {1, 2, 3, 4};
        reverseString(s);
        reverseArray(arr);
    }

    public static void reverseString(char[] s) {
//        TC=O(N)
//        SC=O(1)
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            swap(i, n - i - 1, s);
        }

        System.out.println(s);
    }

    public static void reverseArray(int[] s) {
//        TC=O(N)
//        SC=O(1)
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            swap(i, n - i - 1, s);
        }

        System.out.println(s);
    }

    private static void swap(int start, int end, int[] s) {
        int temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    private static void swap(int start, int end, char[] s) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }


    public void reverseString_Brute(char[] s) {
        int n = s.length;
        char[] newArr = new char[n];
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            newArr[j] = s[i];
            j++;
        }

        for (int i = 0; i < n; i++) {
            s[i] = newArr[i];
        }

    }


}
