package array.medium;

// Negative values are not taken as minimum
// checked only on the right side of the minimum number
public class BestTimeToBuyAndSell {

    public static void main(String[] args) {

        int array[] = {8, 1, 5, 4, 3, 6, 7};

        System.out.println("ANS " + findMaxProfit(array));
    }

    static int findMaxProfit(int prices[]) {

        int mini = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            maxProfit = Math.max(cost, maxProfit);
            mini = Math.min(mini, prices[i]);

        }

        return maxProfit;
    }
}
