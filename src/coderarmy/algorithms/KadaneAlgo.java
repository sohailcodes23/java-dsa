package coderarmy.algorithms;


// take sum of the elements and return the largest sum, we can get within the sub array
// IMP : if sum < 0 than sum =0;
public class KadaneAlgo {

    public static void main(String[] args) {
        int array[] = {3, 4, -5, 8, -12, 7, 6, -12};
        System.out.println("ANS " + largestSumContiguousSubArray_Optimised(array));
    }

    // long was required in gfg
    long maxSubarraySum(int array[], int n) {

//        TC=> O(N)
//        SC=> O(1)
        long maxi = Integer.MIN_VALUE;
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + array[i];

            maxi = Math.max(maxi, prefixSum);
            if (prefixSum < 0) {// Accd to Kadane Algo, it just makes the whole sum a smaller value than the current sum, so we just make it 0
                prefixSum = 0;
            }
        }

        return maxi;
    }

    public static int largestSumContiguousSubArray_Optimised(int[] array) {

//        TC=> O(N)
//        SC=> O(1)
        int n = array.length;

        int maxi = Integer.MIN_VALUE;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + array[i];

            maxi = Math.max(maxi, prefixSum);
            if (prefixSum < 0) {// Accd to Kadane Algo, it just makes the whole sum a smaller value than the current sum, so we just make it 0
                prefixSum = 0;
            }
        }

        return maxi;
    }

    public static int largestSumContiguousSubArray_Better(int[] array) {

//TC=> O(N^2)
        int n = array.length;

        int maxi = Integer.MIN_VALUE;
        // Explanation :
        // n=4
        // i =0 ==> 0  0,1  0,1,2 0,1,2,3
        // i =1 ==> 1  1,2  1,2,3
        // i =2 ==> 2  2,3
        // i =3 ==> 3

        // to get sum of all sum array we are checking maxi in inner loop, if we keep it outside of j loop, it will always check from 0,3  1,3  2,3  3,3 and we don't want that

        for (int i = 0; i < n; i++) {
            int prefixSum = 0;
            for (int j = i; j < n; j++) {
                prefixSum = prefixSum + array[j];
                //IMP
                maxi = Math.max(maxi, prefixSum);// if n=3, this is inside bcz the sum is from i to j, like 0 to 2, later on 1 to 3....., so it will be creating sub arrays
                // if you keep the maxi out of this loop, than it will always sum from start to end like if i=1 than 1 to 3, but we want 1 to and 1 to 3 as well, so in inner loop it will always check the sub array sum
            }
        }

        return maxi;
    }
}
