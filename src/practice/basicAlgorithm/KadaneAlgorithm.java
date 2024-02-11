package practice.basicAlgorithm;

// take sum of the elements and return the maximum sum we can get within the array
// IMP : if sum < 0 than sum =0;
public class KadaneAlgorithm {
    public static void main(String[] args) {

        int array[] = {1, 2, 7, -4, 3, 2, -10, 9, 1};

        System.out.printf("ANS " + maxSubarraySum(array, array.length));
    }

    public static long maxSubarraySum(int[] arr, int n) {

        long maxi = Integer.MIN_VALUE;// to compare we are taking minimum value
        long sum = 0;
        for (int i = 0; i < n; i++) {

            sum = sum + arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {// so that fresh calculation can be done
                sum = 0;
            }
        }

        return Math.max(maxi, 0); // if the max value is <0 so return 0;
    }

    //leetcode
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        long maxi = Integer.MIN_VALUE;// to compare we are taking minimum value
        long sum = 0;
        for (int i = 0; i < n; i++) {

            sum = sum + arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {// so that fresh calculation can be done
                sum = 0;
            }
        }
        return (int) maxi;

    }
}
