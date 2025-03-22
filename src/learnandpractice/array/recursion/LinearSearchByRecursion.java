package learnandpractice.array.recursion;

public class LinearSearchByRecursion {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 89, 45, 23, 78};
        System.out.println(LinearSearchByRecursion(nums, 79));
    }

    static int LinearSearchByRecursion(int nums[], int target) {
        return helper(0, nums, target);
    }

    static int helper(int i, int nums[], int target) {
        if (i > nums.length - 1) {
            return -1;
        }

        if (nums[i] == target) {
            return i;
        }

        return helper(i + 1, nums, target);
    }
}
