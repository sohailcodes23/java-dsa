package recursion.basic;

//https://www.youtube.com/watch?v=69ZCDFy-OUo
// EX=> n= 3, than sum wil be 6 bcz 1+2+3 = 6
// EX=> n= 4, than sum wil be 10 bcz 1+2+3+4 = 10

//        TS => O(N) , no. of time the loops ran
//        SC (Space Complexity => Auxillary Space) => O(N), Bcz N function are awaiting to be completed, So each function call will take some space in stack. Ignore the unit functions
public class SumOfN_Numbers {
    static int sum = 0;

    public static void main(String[] args) {
//        sumOfN_Numbers_Parameterised(4, 0);
        System.out.println("SUM " + factorialOfN_Numbers_Functional(4));
    }

    // Functional way
    // for more info refer sumOfN_Numbers_Functional_Optimised
    static int factorialOfN_Numbers_Functional(int n) {
//        TS => O(N) , no. of time the loops ran
//        SC (Space Complexity => Auxillary Space) => O(N), Bcz N function are awaiting to be completed, So each function call will take some space in stack. Ignore the unit functions

        //n=4 ==> 24
        if (n == 1) { // changed from below sum function
            return 1;
        }

        // 4* 3
        // 3 * 2
        // 2*1
        return n * factorialOfN_Numbers_Functional(n - 1);
    }

    // Functional way
    static int sumOfN_Numbers_Functional_Optimised(int n) {
        //n=3
        if (n == 0) {
            return 0;
        }

        // Backtracking is used, no of loops depends on n value, here for EX it is 3
        // when 3rd loop is completed 1+0 = 1, here left value is n and right is sumOfN_Numbers_Functional_Optimised(n - 1)
        // when 2nd loop is completed 1+2 = 3
        // when 1st loop is completed 3+3 = 6
        return n + sumOfN_Numbers_Functional_Optimised(n - 1);
    }

    // Wrong approach, working but we have used sum variable, we need to create without sum
    // Functional way
    static int sumOfN_Numbers_Functional(int i) {
        //i=3
        if (i < 1) {
            return sum;
        }
        // 1st time = i=3 and sum =>    (0+3)= 3
        // 2nd time = i=2 and sum =>    (3+2)= 5
        // 3rd time = i=1 and sum =>    (5+1)= 6
        sum = sum + i;
        sumOfN_Numbers_Functional(i - 1);

        return sum;
    }

    // parameterised way
    static void sumOfN_Numbers_Parameterised(int i, int sum) {
        //i=3
        if (i < 1) {
            System.out.println("SUM " + sum);
            return;
        }
        // 1st time = i=3 and sum =>    (0+3)= 3
        // 2nd time = i=2 and sum =>    (3+2)= 5
        // 3rd time = i=1 and sum =>    (5+1)= 6
        sumOfN_Numbers_Parameterised(i - 1, sum + i);
    }

}
