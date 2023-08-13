package linearSeach;

public class NumberSearchInRange {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 45, 56, 8};

        System.out.println(linearSearch(array, 1, 0, 4));
    }


    static int linearSearch(int[] sourceArray, int target, int start, int end) {


        for (int index = start; index < end; index++) {
            int element = sourceArray[index];
            if (element == target) {
                return index;
            }
        }
        return Integer.MAX_VALUE;
    }
}
