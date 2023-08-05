package general;

import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        char value = scanner.next().charAt(0);


        if (value >= 'a' && value <= 'z') {
            System.out.println("LOWER");
        } else {
            System.out.println("UPPER");
        }
    }
}
