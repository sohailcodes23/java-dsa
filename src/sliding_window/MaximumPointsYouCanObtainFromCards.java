package sliding_window;

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 1};// k = 3 // OP : 12
    }

    public static int maxScore(int[] cardPoints, int k) {
//        TC=> O(2K)
//        SC=> O(1)
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        int maxSum = 0;

        // to calculate left sum till 0 to k-1, total k elements
        for (int i = 0; i <= k - 1; i++) {
            lsum += cardPoints[i];
        }

        maxSum = lsum;

        int rIndex = k - 1;
        // to calculate right sum and remove that no. of elements from left
        for (int i = n - 1; i >= 0 && rIndex >= 0; i--) { // rIndex>=0, so it doesn't go less than 0

            // first remove one element from the left, we are removing the last element bcz we can only calculate the ,ax sum from start or from the end of array
            lsum = lsum - cardPoints[rIndex];

            rsum += cardPoints[i];

            rIndex--;// as we are adding the rsum, we need to remove the value from leftsum
            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }
}
