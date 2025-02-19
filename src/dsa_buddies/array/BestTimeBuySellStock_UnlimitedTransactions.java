package dsa_buddies.array;

public class BestTimeBuySellStock_UnlimitedTransactions {

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
//        int[] a = {1, 5, 3, 6, 4, 8};

        System.out.println("M " + maxProfit_Brute(a));
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

        int localMin = arr[0];
        int localMax = arr[0];
        int currMax = 0;
        int totalMax = 0;
        boolean sell = false;
        for (int i = 1; i < n; i++) {
            if (sell) {
                localMin = arr[i];
                sell = false;
            }

            if (localMax < arr[i]) {
                localMax = arr[i];
            } else {
                currMax = localMax - localMin;
                totalMax = totalMax + currMax;
                sell = true;
            }
        }

        return totalMax;
    }
}
