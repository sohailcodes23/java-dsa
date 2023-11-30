package practice.string;

// the input : 1221 , the next palindrome that comes after the input OP : 1331
public class NextSmallestPalindrome_S2 {

    public static void main(String[] args) {


//        System.out.println("ANS " + nextLargestPalindrome("97531", 3));
//        System.out.println("ANS " + nextLargestPalindrome("23545", 3));
        System.out.println("ANS " + nextLargestPalindrome("999"));
    }
    // Main function to solve the problem

    public static String nextLargestPalindrome(String a) {


        // Check if the string is already a palindrome, if yes, add 1
        if (isPalindrome(a)) a = add1(a);

        // If adding 1 results in a palindrome, return the result
        if (isPalindrome(a)) return a;

        int n = a.length();
        int mid = n / 2;
        String left = a.substring(0, mid + (n % 2)); // Adjust mid for odd length
        String right = a.substring(mid);

        // If the left part is greater, increment it; otherwise, use it as is
        left = (compare(reverse(left), right) == 1) ? left : add1(left);

        // Return the palindrome formed by left and its reversed part
        return left + reverse(left.substring(0, mid));
    }

    // Check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

    // Reverse a string
    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Compare two strings lexicographically
    private static int compare(String left, String right) {
        return left.compareTo(right);
    }

    // Add 1 to a numeric string
    private static String add1(String str) {
        int carry = 1;
        StringBuilder result = new StringBuilder();

        // Iterate over each digit in reverse order
        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(str.charAt(i)) + carry;
            result.append(digit % 10); // Append the last digit of the sum
            carry = digit / 10; // Determine the carry for the next iteration
        }

        // If there's a carry after the loop, append it
        if (carry != 0) result.append(carry);

        return result.reverse().toString(); // Return the reversed result
    }


}
