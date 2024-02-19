package coderarmy.binarysearch;

public class FindKthMissingPositiveNo {

    public static void main(String[] args) {

        int array[] = {2, 3, 4, 7, 11, 12};

        System.out.println("ANS " + findKthPositive(array, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        // Quest : 2 3 4 7 11 12
        // Actual: 1 2 3 4 5  6
        // Diff  : 1 1 1 3 6  6 == > (arr[mid] - mid - 1)

//        TC=> O(log N)
//        SC=> O(1)

        int n = arr.length;
        int ans = arr.length;// assigning array size bcz if all the elements are at their 1th index position, than we need to handle tha
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((arr[mid] - mid - 1) >= k) {//(arr[mid] - mid - 1) = to the diff of element and the actual elements that should have been there, check above
                ans = mid;// we are adding this with end bcz, it will move to left, bcz right is already >= k
                end = mid - 1;
            } else {// move left
                start = mid + 1;
            }
        }

        // Here ans is the index where that actual positive no. was supposed to be there
        return ans + k;
    }
}
