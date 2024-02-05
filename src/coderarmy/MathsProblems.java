package coderarmy;

public class MathsProblems {

    public static void main(String[] args) {
//        System.out.println(mySqrt(8));
//        System.out.println(findTrailingZeroInFactorial(148));
        System.out.println(totalMovesForBishop(3, 4));
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

        if (n < 1) {
            return false;
        }

        while (n != 1) {// n!=1 bcz when we are dividing n, the quotient should go only till 1

            if (n % 2 != 0) {// if n is not even
                return false;
            }
            n = n / 2;
        }

        return true; // is power of 2
    }

    // works for most case, not all like : 2147395600
    public static int mySqrt(int x) {
        int i = 0;
        int value = 0;
        while (value < x) {
            i++;
            value = i * i;
        }
        if ((i * i) > x) {
            return i - 1;
        }

        return i;
    }

    static Long squaresInChessBoard(Long N) {
        // code here
        long ans = 0;
        while (N > 0) {
            ans = (N * N) + ans;
            N--;
        }

        return ans;
    }

    static boolean armstrong(int n) {

        int count = 0;
        int tempN = n;
        while (tempN > 0) {
            tempN = tempN / 10;
            count++;
        }
        System.out.println("C " + count);
        int ans = 0;
        tempN = n;
        int mul = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;

            ans = (int) Math.pow(rem, count) + ans;
        }

        if (ans == tempN) {
            return true;
        }

        return false;
    }

    static int findTrailingZeroInFactorial(int n) {
        // 6! ==>720, so ans is 1
        // 25! ==>15511210043330985984000000, so ans is =6
        int ans = 0;

        while (n >= 5) {// only till 5 bcz 0 will only be found from the factorial of 5 and so on

            ans = ans + (n / 5);
            n = n / 5;// to keep diving and decreasing the number
        }
        return ans;
    }

    public static int totalMovesForBishop(int A, int B) {
// think like you are in the middle of the chess board
        // bishop only goes diagonally
        int count = 0;

        count = count + Math.min(8 - A, B - 1);//left bottom//
        count = count + Math.min(A - 1, 8 - B);//right bottom
        count = count + Math.min(8 - A, 8 - B);//right top //
        count = count + Math.min(A - 1, B - 1);//left top//

        return count;
    }
}
