package coderarmy.binarysearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {

        int array[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("ANS " + search(array, 1));
    }

    public static int search(int[] nums, int target) {
        // TC=> O(log N)
        // SC=> O(1)
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                break;
            } else if (nums[mid] >= nums[0]) {// checking left part of array from mid

                // now to search, we need to check if we need to go to left or right
                if (nums[start] <= target
                        && nums[mid] >= target) {// to move left if the first element < = target < = mid
                    end = mid - 1;
                } else {// move right
                    start = mid + 1;
                }
            } else {// checking right part
                if (nums[end] >= target
                        && nums[mid] <= target) {// to move right if the last element > = target > = mid
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return ans;

    }
}
