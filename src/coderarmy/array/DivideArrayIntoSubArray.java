package coderarmy.array;

public class DivideArrayIntoSubArray {
    public static void main(String[] args) {

        int[] array = {3, 4, -2, 5, 8, 20, -10, 8};

        // size 1
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //size 2
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < i + 2 && j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }

        // size 3
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i; j < i + 3 && j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }

//    .... for all the partition int j=i+ (sizeOfPartition)
}
