package learnandpractice.recursion;

public class CheckStringIsPalindrome {

    public static void main(String[] args) {
//        String a = "MADAM";// true
//        String a = "ABA";// true
//        String a = "ABHDEGRDHBA";// false
        String a = "ACHDEGRDHBA";// false
        System.out.println(isPalindrome(a, 0));
    }


    static boolean isPalindrome(String a, int i) {
        int n = a.length();
        if (i == n / 2) {
            return true;
        }
        int j = n - i - 1;
        if (a.charAt(i) != a.charAt(j)) {
            return false;
        }
        return isPalindrome(a, i + 1);
    }
}
