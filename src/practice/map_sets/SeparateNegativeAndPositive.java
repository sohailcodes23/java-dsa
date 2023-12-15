package practice.map_sets;

import java.util.Arrays;

public class SeparateNegativeAndPositive {

    public static void main(String[] args) {

        int[] array = {1, -2, 3, 4, -5};

        System.out.println("ANS " + Arrays.toString(separateNegativeAndPositive(array)));
    }

    public static int[] separateNegativeAndPositive(int a[]) {

        int l = 0;
        int r = a.length - 1;


        while (l < r) {

            if (a[l] >= 0 && a[r] < 0) { // l>=0 so that if the values at left are greater than 0 tha it should be on right side. vice versa for right
                int temp = a[r];
                a[r] = a[l];
                a[l] = temp;

                l++;
                r--;
            } else if (a[l] < 0) { // if the value at left is already <0 i.e. -ve number
                l++;
            } else { // if values at right is already positve
                r--;
            }

        }


        return a;
    }
}
