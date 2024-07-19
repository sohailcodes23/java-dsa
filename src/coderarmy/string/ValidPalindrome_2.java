package coderarmy.string;

public class ValidPalindrome_2 {

    public static void main(String[] args) {

    }

    public static boolean validPalindrome(String s) {

//        TC=> O(N)
//        SC=> O(1)
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {// the reason we are checking isPalindrome, bcz we want to eliminate one of the chars
                //EX : a a a z, i != j, so we check using isPalindrome method from a a z || from a a a
                // If any one return true that it's a palindrome by deleting one record
                // the string that was matched in the if condition is already a Palindrome
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }

        return true; // If no mismatch is found, it's already a palindrome
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }

        return true;
    }
}
