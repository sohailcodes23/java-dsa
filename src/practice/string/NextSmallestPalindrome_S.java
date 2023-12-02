package practice.string;

// the input : 1221 , the next palindrome that comes after the input OP : 1331
public class NextSmallestPalindrome_S {

    public static void main(String[] args) {


//        System.out.println("ANS " + nextLargestPalindrome("97531", 3));
//        System.out.println("ANS " + nextLargestPalindrome("23545", 3));
        System.out.println("ANS " + nextLargestPalindrome("999"));
    }
    // Main function to solve the problem

    public static String nextLargestPalindrome(String a) {
        // If the input is already a palindrome, add 1 and check again
        if (isPalindrome(a)) a = add1(a);

        // If adding 1 also results in a palindrome, return the result
        if (isPalindrome(a)) return a;

        int n = a.length();

        // If the length is odd, handle odd case; otherwise, handle even case
        if ((n & 1) == 1) {
            return handleOdd(a);
        } else {
            return handleEven(a);
        }
    }


    // Check if a string is a palindrome
    public static boolean isPalindrome(String a) {
        return a.equals(new StringBuilder(a).reverse().toString());
    }

    // Compare two strings lexicographically
    public static int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
            if (l > r) return 1;
            else if (l < r) return -1;
        }
        return 0;
    }

    // Add 1 to a numeric string
    public static String add1(String x) {
        StringBuilder ns = new StringBuilder();
        int carry = 1;

        // Iterate over each digit in reverse order
        for (int i = x.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(x.charAt(i)) + carry;
            ns.append(digit % 10); // Append the last digit of the sum
            carry = digit / 10;    // Determine the carry for the next iteration
        }

        // If there's a carry after the loop, append it
        if (carry != 0) ns.append(carry);

        return ns.reverse().toString(); // Return the reversed result
    }

    // Handle the case for an odd-length string
    public static String handleOdd(String a) {
        int n = a.length();
        int mid = n / 2;
        String left = a.substring(0, mid);
        String right = a.substring(mid + 1);

        // Compare the reversed left part with the right part
        if (compare(new StringBuilder(left).reverse().toString(), right) == 1) {
            return left + a.charAt(mid) + new StringBuilder(left).reverse();
        } else {
            left = left + a.charAt(mid);
            left = add1(left); // Add 1 to the left part
            return left + new StringBuilder(left).reverse().substring(1);
        }
    }

    // Handle the case for an even-length string
    public static String handleEven(String a) {
        int n = a.length();
        int mid = n / 2;
        String left = a.substring(0, mid);
        String right = a.substring(mid);

        // Compare the reversed left part with the right part
        if (compare(new StringBuilder(left).reverse().toString(), right) == -1) {
            left = add1(left); // Add 1 to the left part
            return left + new StringBuilder(left).reverse().toString();
        } else {
            return left + new StringBuilder(left).reverse().toString();
        }
    }


    //v2
//    public static String nextLargestPalindrome(String a, int length) {
//        // Check if the string is already a palindrome, if yes, add 1
//        if (isPalindrome(a)) a = add1(a);
//
//        // If adding 1 results in a palindrome, return the result
//        if (isPalindrome(a)) return a;
//
//        int n = a.length();
//        int mid = n / 2;
//        String left = a.substring(0, mid + (n % 2)); // Adjust mid for odd length
//        String right = a.substring(mid);
//
//        // If the left part is greater, increment it; otherwise, use it as is
//        left = (compare(reverse(left), right) == 1) ? left : add1(left);
//
//        // Return the palindrome formed by left and its reversed part
//        return left + reverse(left.substring(0, mid));
//    }
//
//    // Check if a string is a palindrome
//    public static boolean isPalindrome(String str) {
//        return str.equals(reverse(str));
//    }
//
//    // Reverse a string
//    public static  String reverse(String str) {
//        return new StringBuilder(str).reverse().toString();
//    }
//
//    // Compare two strings lexicographically
//    public static  int compare(String left, String right) {
//        return left.compareTo(right);
//    }
//
//    // Add 1 to a numeric string
//    public static  String add1(String str) {
//        int carry = 1;
//        StringBuilder result = new StringBuilder();
//
//        // Iterate over each digit in reverse order
//        for (int i = str.length() - 1; i >= 0; i--) {
//            int digit = Character.getNumericValue(str.charAt(i)) + carry;
//            result.append(digit % 10); // Append the last digit of the sum
//            carry = digit / 10; // Determine the carry for the next iteration
//        }
//
//        // If there's a carry after the loop, append it
//        if (carry != 0) result.append(carry);
//
//        return result.reverse().toString(); // Return the reversed result
//    }
}
