package coderarmy.string;

import java.util.ArrayList;

public class FactorialOfNumber {

    public static void main(String[] args) {
        System.out.println("ANS " + factorial(5));
        System.out.println("ANS " + factorial(10));
    }

    static ArrayList<Integer> factorial(int N) {

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        // TC=> O(N)
        while (N > 1) { //N>1, bcz we dont want to multiply by 1

            int carry = 0;
            int result = 0;
            int size = ans.size();
            // TC=> O(N)
            for (int i = 0; i < size; i++) {
                result = ans.get(i) * N + carry;
                carry = result / 10;// to remove the last number, EX carry=56, so after this it will be 5
                ans.set(i, result % 10); // result%10, so that we only set the last number on ith index, EX: 56, so we want to set 6 on the ith index
            }

            // TC=> O(N), but this is negligible
            while (carry > 0) {// so if carry is 123
                ans.add(carry % 10); // after mod, it will add 3 in the ans
                // 2nd loop: than 2 in the ans ...
                carry = carry / 10; // after setting the last digit, it will remove that digit from carry
            }

            N--;
        }

        int i = 0;
        int j = ans.size() - 1;
        // TC=> O(N), but this is negligible
        while (i < j) {
            swap(ans, i, j);
            i++;
            j--;
        }
        return ans;
    }

    static void swap(ArrayList<Integer> arr, int l, int r) {
        int temp = arr.get(l);
        arr.set(l, arr.get(r));
        arr.set(r, temp);
    }

}
