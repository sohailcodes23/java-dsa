package practice.array;

public class EquilibriumIndex {

    public static void main(String[] args) {

//        int array[] = {1, 7, 3, 6, 5, 6};
        int array[] = {20, 9, 7, 3, 5, 5};

        System.out.println("ANS " + pivotIndex(array));
    }

    public static int pivotIndex(int[] nums) {

//        TC=>O(2N) -> O(N), bcz we drop constants so O(N)
//        SC=> O(2)
        int n = nums.length;

        if (n == 1) { // if single element than that is pivot
            return 0;
        }

        int totalSum = 0;
        for (int i : nums) { // to get the whole sum
            totalSum = totalSum + i;
        }

        int previousLeftSum = 0; // once we move forward we need to have the old sum and this old side will be on the left sum

        for (int i = 0; i < n; i++) {

            int currentElement = nums[i];
            int left = previousLeftSum; // to get the previous sum, only than we will know what's the left sum
            int right = totalSum - (left + currentElement); // this can also be written as "totalSum - left - currentElement;" Here we are substracting currentElement bcz we have the left sum but the right sum should not include the current element


            if (left == right) { // required condition
                return i;
            }


            previousLeftSum = previousLeftSum + nums[i]; // saving old sum, which can be used as left sum
        }


        return -1;
    }
}
