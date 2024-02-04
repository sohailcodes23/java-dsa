package coderarmy;

public class MathsProblems {

    public static void main(String[] args) {
    }

    public int addDigits(int num) {

        int lastDigit = 0;
        int ans = 0;
        int mul = 1;

        while (num > 9) {// to run the loop until tha ans is one digit

            ans = 0;
            while (num != 0) {

                lastDigit = num % 10;
                num = num / 10;
                ans = lastDigit + ans;
            }
            num = ans;
        }
        return ans;

    }

    static int isLeap(int N) {
        //code here
        if (N % 400 == 0) {
            return 1;
        } else if (N % 4 == 0 && N % 100 != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int reverse(int x) {

        int rem = 0;
        int ans = 0;
        int mul = 1;
        boolean done = false;
        if (x < 0) {
            x = x * -1;
            done = true;
        }
        while (x > 0) {
            rem = x % 10;
            x = x / 10;
            //In  : ans*10 cause major changes in number and rem is always between 0-9
            // NOW if ans*10 > Integer.MAX_Value, so /n => ans > Int.Max_Value/10
            // NOW if ans*10 < Integer.MIN_Value, so /n => ans < Int.Max_Value/10
            if (ans > (Integer.MAX_VALUE / 10) || ans < (Integer.MIN_VALUE / 10)) {
                return 0;
            }
            ans = ans * 10 + rem;
        }

        if (done) {
            ans = ans * -1;
        }


        return ans;
    }

    public boolean isPowerOfTwo(int n) {

        if(n<1){
            return false;
        }

        while(n!=1){// n!=1 bcz when we are dividing n, the quotient should go only till 1

            if(n % 2!=0){// if n is not even
                return false;
            }
            n=n/2;
        }

        return true; // is power of 2
    }
}
