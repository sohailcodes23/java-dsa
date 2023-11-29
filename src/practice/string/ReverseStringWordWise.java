package practice.string;

import java.util.Scanner;

public class ReverseStringWordWise {

    //Hello I am Testing words
    //words Testing am I Hello
    static String reverseStringWordWise(String input) {
        String inputValues[] = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = inputValues.length - 1; i >= 0; i--) {
            stringBuilder.append(" " + inputValues[i]);
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = reverseStringWordWise(input);
        System.out.println(ans);
    }
}
