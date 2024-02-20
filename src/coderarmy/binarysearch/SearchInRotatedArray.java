package coderarmy.binarysearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {

//        int array[] = {4, 5, 6, 7, 0, 1, 2};
        int array[] = {1, 0, 1, 1, 1};
        System.out.println("ANS " + search(array, 0));
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

    public boolean searchV2(int[] nums, int target) {
//        TC=> O(log N)
//        SC=> O(1)
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[start] == nums[mid]) {

                start++;
                // continue;
            } else if (nums[mid] >= nums[start]) {// left side is sorted, so the element is on the right side

                if (nums[start] <= target && nums[mid] >= target) {// bcz if mid >= target that means the target is at left side
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {

                if (nums[end] >= target && nums[mid] <= target) {// if mid<=target that means target is at right
                    start = mid + 1;

                } else {
                    end = mid - 1;

                }

            }
        }
        return false;
    }

}
