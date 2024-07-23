package coderarmy.string;

public class IntegerToRoman {

    public static void main(String[] args) {

        System.out.println("ANS " + intToRoman(3749));
    }

    public static String intToRoman(int num) {
        // TC=O(1), bcz the num is always within 1 to 3999, and at most we are checking 13 roman values, so it's constant
        // SC=O(1), bcz the num is always within 1 to 3999, and at most we are checking 13 roman values, so it's constant, so StringBuilder used here is negligible

        // Based on the rules we have added new no.s in the map
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};// NOTE: values ans symbols are mapped, so the index of the value and symbol should be matching
        String symbols[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {// bcz we will be subracting the value so > 0
            if (num >= values[i]) {// if num is greater we will check in the map and substract it
                // EX : 3749, here 3749 > 1000 ("M"), so num= 3749-1000 == 2749
                // 2nd loop: here 2749 > 1000 ("M"), so num= 2749-1000 == 1749, this goes on and on till the num = 0
                stringBuilder.append(symbols[i]);// appending on the ith index, bcz we have properly mapped above
                num = num - values[i];
            } else {
                i++;// move to next symbol, bcz now the current num is < value[i]
            }
        }

        return stringBuilder.toString();
    }
}
