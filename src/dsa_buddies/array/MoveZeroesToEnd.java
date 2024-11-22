package dsa_buddies.array;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        // TC=> O(N)
        int n = nums.length;

        if (n > 1) {
            int j = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    j = i;
                    break;
                }
            }

            if (j != -1) {

                for (int i = j + 1; i < n; i++) {
                    if (nums[i] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;

                        j++;
                    }
                }
            }
        }
    }

    public static void moveZeroes_better(int[] nums) {
        int n = nums.length;

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // Setting rest of the element as 0
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }

        System.out.println("AA " + Arrays.toString(nums));
    }


}
