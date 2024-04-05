package coderarmy;

//Maximum Difference between Two Elements such that Larger Element Appears after the Smaller Element

//basically if index is at 2, than the max diff between index 2 and right side of the pending array elements
public class MaximumDifferenceBetweenTwoElements {

    public static void main(String[] args) {

//        int array[] = {9, 5, 8, 12, 2, 3, 7, 4};
//        int array[] = {2, 3, 10, 6, 4, 8, 1}; //8
        int array[] = {7, 9, 5, 6, 3, 2}; //2
        System.out.println("ANS " + maxDiff(array));
    }

    //Brute: It will be O(N^2), bcz we will take 2 for loops
    // 1st loop i, will take the element
    // 2nd loop j, will be j=i+1 and it will traverse till n-1, and assign the max value in maxi

    //Optimised
    static int maxDiff(int arr[]) {

//        TC=>O(N)
//        SC=>O(1)

        int n = arr.length;

        int maxi = Integer.MIN_VALUE;
        int suffixMax = arr[n - 1];// assigning the last element bcz of suffix traverse

        for (int i = n - 2; i >= 0; i--) {//             n-2, bcz we have already assigned suffixMax as n-2, so the loop starts from n-2

            suffixMax = Math.max(suffixMax, arr[i]);// will assign the MAX element from the suffix traverse

            maxi = Math.max(maxi, suffixMax - arr[i]);// MAX - current Element, this will give the diff and we can take the maxi value
        }

        return maxi;
    }
}
