package own;

public class MaxSumOfSubarray {
    //Find sum of every contiguous subarray of size k.
    //arr = [1,2,3,4,5]
    //k = 3

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int n = a.length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            if (i >= k - 1) {
                max = Math.max(sum, max);

                sum = sum - a[i - k + 1];
            }
        }
        System.out.println(max);
    }


}
