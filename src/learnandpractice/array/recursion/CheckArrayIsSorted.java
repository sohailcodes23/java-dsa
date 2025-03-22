package learnandpractice.array.recursion;

public class CheckArrayIsSorted {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
//        int nums[] = {1, 2, 6, 4, 5};
        System.out.println(isSorted(nums));
    }

    static boolean isSorted(int nums[]) {

        return helper3(0, nums);
    }

    static boolean helper3(int i, int nums[]) {

        if (i == nums.length - 1) {// if i is at last element that means it's sorted
            return true;
        }

        return nums[i] < nums[i + 1] && helper3(i + 1, nums);// i+1 moving to next element, this is checking the false condition
    }

    static boolean helper2(int i, int nums[]) {

        if (i <= nums.length - 2 && nums[i] > nums[i + 1]) {// check i < i+1, if not even once that it's not sorted
            return false;
        } else if (i == nums.length - 1) {// if i is at last element that means it's sorted
            return true;
        }

        return helper2(i + 1, nums);// i+1 moving to next element
    }

    static boolean helper(int i, int j, int nums[]) {

        if (i < nums.length && j < nums.length && nums[i] > nums[j]) {
            return false;
        } else if (i == nums.length - 1) {
            return true;
        }

        return helper(i + 1, j + 1, nums);
    }
}
