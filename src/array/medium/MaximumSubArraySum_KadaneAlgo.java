package array.medium;


// Kadane's Algo:
// 1. Take a sum and maxSum;
// 2. Add value in the sum and compare with max if (sum > max) max= sum
// 3. if(sum <0) sum =0
public class MaximumSubArraySum_KadaneAlgo {

    public static void main(String[] args) {


        int array[] = {1, 2, 7, -4, 3, 2, -10, 9, 1};

        System.out.println("ANS " + maxSubarraySum_Optimal(array, array.length));
    }


    static long maxSubarraySum_Optimal(int[] arr, int n) {

//        TC=> O(N)
//        SC=> O(1)

        long maxi = Integer.MIN_VALUE;
        long sum = 0;
        int start = -1;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) { // to print the array
                start = i;
            }
            sum = sum + arr[i];

            if (sum > maxi) {
                maxi = sum;

                // for printing the max sum array
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        for (int i = ansStart; i <= ansEnd; i++) { // to print the array
            System.out.print(arr[i]+", ");
        }

        return Math.max(maxi, 0);
    }

    static long maxSubarraySum_Better(int[] arr, int n) {

//        TC=> O(N^2)
//        SC=> O(1)
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }


        return maxSum;
    }


    // Brute same as better but a third loop and sum is initialised in j loop and added in the third loop
}
