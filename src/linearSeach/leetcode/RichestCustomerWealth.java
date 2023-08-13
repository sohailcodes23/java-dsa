package linearSeach.leetcode;

//https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3, 99}, {3, 2, 1, 8}};
        System.out.println("ANS " + maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int maxValue = 0;
//        for (int person = 0; person < accounts.length; person++) {
//            int personValue = 0;
//            for (int account = 0; account < accounts[person].length; account++) {
//                // Not 'accountValue', you missed this, get the value
//                int accountValue = accounts[person][account];
//                personValue = personValue + accountValue;
//            }
//
//            if (maxValue < personValue) {
//                maxValue = personValue;
//            }
//        }

        // Optimised
        for (int[] person : accounts) {
            int personValue = 0;
            for (int accountValue : person) {
                personValue = personValue + accountValue;
            }

            if (maxValue < personValue) {
                maxValue = personValue;
            }
        }

        return maxValue;
    }
}
