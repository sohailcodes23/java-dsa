package practice.array;

public class FrequencyInSortedArray {

    public static void main(String[] args) {
        int array[] = {1, 1, 2, 2, 2, 2, 3};

        System.out.println("ANS " + countOccurrences(array, 2));
    }

    public static int countOccurrences(int[] arr, int x) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }

        return count;
    }

}
