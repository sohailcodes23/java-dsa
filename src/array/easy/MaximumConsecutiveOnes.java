package array.easy;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        int a[] = {
                0, 1, 1, 0, 0, 1, 1, 1
        };

        System.out.println("ANS " + consecutiveOnes(a));
    }

    public static int consecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }

        return max;
    }
}
