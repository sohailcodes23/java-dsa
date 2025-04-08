package learnandpractice.array;


//Maximum Difference between Two Elements such that Larger Element Appears after the Smaller Element
//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class MaximumDifferenceTwoElements {
    /// MISTAKE: We are assuming the first max and the first min will always give the max distance between the elements
    /// This is wrong:EX {9, 11, 8, 5, 7, 10}, Here our code is taking 11-9=2, but there are other elements like 10-5=5, this gives more max distance
    public static void main(String[] args) {
//        int a[] = {2, 3, 10, 6, 4, 8, 1};// 8
//        int a[] = {7, 9, 5, 6, 3, 2};// 2
//        int a[] = {4, 3, 3, 2, 1};// -1
//        int a[] = {1, 2, 90, 10, 110};// 109
//        int a[] = {10, 2, 90, 1, 110};// 109
        int a[] = {9, 11, 8, 5, 7, 10};// 5 but getting 2 // EDGE case: without any wrong assumption
        System.out.println(maximumDifferenceTwoElements_Optimised(a));
        System.out.println(maximumDifferenceTwoElements_NotWorkingInALlScenarios(a));
    }

    // CHeck Mistake for better understanding
    static int maximumDifferenceTwoElements_Optimised(int arr[]) {
        //TC=> O(2N) ==> O(N)
        // SC=> O(1)
        int n = arr.length;
        int largestEle = Integer.MIN_VALUE;
        int smallestEle = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            smallestEle = Math.min(smallestEle, arr[i]);
            largestEle = Math.max(largestEle, arr[i] - smallestEle);//MIS: arr[i]-smallestEle: it will check the distance till that current element
        }
        return largestEle;
    }


    static int maximumDifferenceTwoElements_NotWorkingInALlScenarios(int arr[]) {
        //TC=> O(2N) ==> O(N)
        // SC=> O(1)
        int n = arr.length;
        int largestEle = Integer.MIN_VALUE;
        int smallestEle = Integer.MAX_VALUE;
        int largestEleIndex = -1;

        // find largest element and it's index
        for (int i = 0; i < n; i++) {
            if (arr[i] > largestEle) {
                largestEle = arr[i];
                largestEleIndex = i;
            }
        }
        if (largestEleIndex == 0) {
            return -1;
        }
        // find the smallest element before the largest value index
        for (int i = 0; i <= largestEleIndex; i++) {
            smallestEle = Math.min(smallestEle, arr[i]);
        }

        return largestEle - smallestEle;
    }
}
