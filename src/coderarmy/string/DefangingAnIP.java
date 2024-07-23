package coderarmy.string;

import java.util.Scanner;

//https://leetcode.com/problems/defanging-an-ip-address/description/
public class DefangingAnIP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        String newVal = new String();

        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));

            if (input.charAt(i) == '.') {
                newVal += "[.]";
                stringBuilder.append("[.]");
            } else {
                newVal += input.charAt(i);
                stringBuilder.append(input.charAt(i));
            }
        }

        System.out.println(newVal + " ANS " + stringBuilder.toString());
    }
}
