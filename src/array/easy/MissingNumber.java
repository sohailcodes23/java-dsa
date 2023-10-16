package array.easy;

public class MissingNumber {

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5};
//        int a[] = {1, 3};

        System.out.println("ANS " + findMissingNumber_Brute(a));
    }

    //OWN
    static int findMissingNumber(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }

        return -1;
    }

    //Brute
    static int findMissingNumber_Brute(int[] nums) {

        for (int i = 1; i <= nums.length; i++) {

            boolean iValueIdPresent = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    iValueIdPresent = true;
                    break;
                }
            }

            if (!iValueIdPresent) {
                return i;
            }
        }
        return -1;
    }

}
