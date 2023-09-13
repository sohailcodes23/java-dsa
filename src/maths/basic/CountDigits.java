package maths.basic;

public class CountDigits {

    public static void main(String[] args) {

        //Own
        int value = 156;
//        int count = 0;
//        while (value > 0) {
//            value = value / 10;
//            count++;
//        }

        //Another approach
        int count = (int) Math.log10(value) + 1;

        System.out.println("ANS " + count);
    }
}
