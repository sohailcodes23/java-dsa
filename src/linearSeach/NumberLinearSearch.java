package linearSeach;

public class NumberLinearSearch {

    public static void main(String[] args) {

//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] array = {};
        int ans = linearSearch1(array, 9);
        System.out.println(ans);
    }

    // to get the index
    static int linearSearch1(int[] array, int target) {

        if (array.length == 0) {
            return -1;
        }

        for (int index = 0; index < array.length; index++) {
            int element = array[index];
            if (element == target) {
                return index;
            }
        }

// bcz the target is not found
        return Integer.MAX_VALUE;

    }


    // to get the element
    static int linearSearch2(int[] array, int target) {

        if (array.length == 0) {
            return -1;
        }

        for (int index = 0; index < array.length; index++) {
            int element = array[index];
            if (element == target) {
                return index;
            }
        }


// bcz the target is not found
        return Integer.MAX_VALUE;

    }

}
