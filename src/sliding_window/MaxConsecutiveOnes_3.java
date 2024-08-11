package sliding_window;

// Find the subarray which has atmost k zeroes:
public class MaxConsecutiveOnes_3 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};//, k = 2 // 6
        System.out.println("FF " + longestOnes_Brute(nums, 2));
        System.out.println("FF " + longestOnes_Better(nums, 2));
    }

    // [1,1,1,0,0,0,1,1,1,1,0], k = 2 ==> so 0 to 4 ith is a sub array, bcz it has only k zeroes
    public static int longestOnes_Better(int[] nums, int k) {
        // TC=>O(N)
        // SC==>O(1)
        int n = nums.length;
        int left = 0, right = 0, maxLen = 0;
        int zeroes = 0;

        while (right < n) {

            if (nums[right] == 0) {// if you find 0, increment zeroes
                zeroes++;
            }

            if (zeroes <= k) {// till the time zeroes <=k we should calculate maxLen, bcz we haven't found the 
                maxLen = Math.max(maxLen, right - left + 1);
            }

            while (zeroes > k) { // when zeroes>k, and we wamt to move left pointer, so if while moving we find any zero we will decrease it
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }

            right++;
        }

        return maxLen;
    }

    public static int longestOnes_Brute(int[] nums, int k) {
        // TC=>O(N^2)
        // SC==>O(1)
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int zeroes = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeroes++;
                }
                if (zeroes <= k) {//calculating the max len of the sub array
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}
