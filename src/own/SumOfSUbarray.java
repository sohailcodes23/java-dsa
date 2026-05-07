package own;

import java.util.ArrayList;
import java.util.List;

public class SumOfSUbarray {
    //Find sum of every contiguous subarray of size k.
    //arr = [1,2,3,4,5]
    //k = 3

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int k = 3;
        int n = a.length;
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            if (i >= k - 1) {
                ans.add(sum);

                sum = sum - a[i - k + 1];
            }
        }
        System.out.println(ans.toString());
    }


}
