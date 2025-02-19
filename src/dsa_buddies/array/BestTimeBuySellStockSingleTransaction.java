package dsa_buddies.array;

public class BestTimeBuySellStockSingleTransaction {

    public static void main(String[] args) {
//        int[] a = {7, 1, 5, 3, 6, 4};
        int[] a = {1, 5, 3, 6, 4, 8};

        System.out.println("M " + maxProfit(a));
    }

    public static int maxProfit(int[] arr) {
//       TC==> O(N)
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {// updating the min value
                min = arr[i];
            } else {// max = current - min
                max = Math.max(max, arr[i] - min);
            }
        }

        return max;

    }

    public static int maxProfit_Brute(int[] arr) {
//       TC==> O(N^2)
        int n = arr.length;

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && arr[j] > arr[i]; j++) {
                max = Math.max(max, arr[j] - arr[i]);
            }
        }

        return max;
    }
}
