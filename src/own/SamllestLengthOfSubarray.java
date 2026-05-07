package own;

public class SamllestLengthOfSubarray {
    //Find sum of every contiguous subarray of size k.
    //arr = [1,2,3,4,5]
    //k = 3

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 1, 3, 2};
        int k = 7;
        int n = a.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            if (sum >= k) {
                min = Math.min(min, i - last + 1);
                sum = sum - a[i - last + 1];
                last = i;
            }
        }
        System.out.println(min);
    }


}
