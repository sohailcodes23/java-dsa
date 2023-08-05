package general;

import java.util.Scanner;

public class CountNumberOccurrence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0;
        while (n > 0) {
            int num = n % 10;
            if (num == 3) {
                count++;
            }
            n = n / 10;

        }

        System.out.println(count);
    }
}
