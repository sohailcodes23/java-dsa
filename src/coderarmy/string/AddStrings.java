package coderarmy.string;

public class AddStrings {

    public static void main(String[] args) {

        System.out.println("ANS " + addStrings("99845", "938"));
    }

    public static String addStrings(String num1, String num2) {
//        TC==> O(N) , here N is the length of bigger string length, loop will atmost run till N
//        SC==> O(N), bcz we used StringBuilder
        if (num1.length() > num2.length()) {
            return addStringBasedOnSize(num1, num2);
        } else {
            return addStringBasedOnSize(num2, num1);
        }
    }

    public static String addStringBasedOnSize(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int sum = 0;
        int carry = 0;
        String ans = "";
        // condition 1: i>=j
        while (j >= 0) {// checking j bcz j has small length
            int value1 = num1.charAt(i) - '0';// '3'-'0' ==> 3, to get the actual num
            int value2 = num2.charAt(j) - '0';// '5'-'0' ==> 5, to get the actual num
            sum = value1 + value2 + carry;
            carry = sum / 10;// to get the value without the units --- 13 : 10
            char ch = (char) ('0' + (sum % 10)); // sum%10 : to get the unit of the sum // '0' - 'sum%10' to revert the int to char

            ans += ch;

            i--;
            j--;
        }
        // pending values in num1, bcz num2 was small
        while (i >= 0) {
            int value1 = num1.charAt(i) - '0';// '3'-'0' ==> 3, to get the actual num
            sum = value1 + carry;
            carry = sum / 10;// to get the value without the units --- 13 : 10
            char ch = (char) ('0' + (sum % 10)); // sum%10 : to get the unit of the sum // '0' - 'sum%10' to revert the int to char

            ans += ch;

            i--;
        }

        if (carry != 0) {
            ans += carry;
        }

        return new StringBuilder(ans).reverse().toString();
    }
}
