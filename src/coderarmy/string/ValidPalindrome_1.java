package coderarmy.string;

public class ValidPalindrome_1 {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println("ANS " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
//        TC=> O(2N)==> O(N)
//        SC=> O(2N)==> O(N)
        s = s.toLowerCase().trim();
        int n = s.length();
        if (n == 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        // extract the alphabets
        for (int i = 0; i < n; i++) {
            int asciiValue = s.charAt(i);// Ascii value
            if ((asciiValue >= 97 && asciiValue <= 122) || (asciiValue >= 48 && asciiValue <= 57)) {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println("JJ "+stringBuilder.toString());
        if (stringBuilder.toString().length() <= 1) {
            return true;
        }

        return stringBuilder.toString().equals(getPalindromeValue(stringBuilder.toString()));
    }

    private static String getPalindromeValue(String a) {
        StringBuilder stringBuilder = new StringBuilder();
        int m = a.length();
        for (int i = m - 1; i >= 0; i--) {
            stringBuilder.append(a.charAt(i));
        }

        return stringBuilder.toString();
    }
}
