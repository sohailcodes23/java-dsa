package coderarmy;

// same can be used for Octal just use 8 in place of 2 or 10
//Binary base:2
//Decimal base:8
//Octal base:8
public class BinaryToDecimalToOctal {

    public static void main(String[] args) {


        toDecimal(1101);//1101
        toBinary(13);// 13

    }

     static void toDecimal(int N) {
        //Write your code here

        int rem = 0;
        int ans = 0, mul = 1;
        ;

        while (N > 0) {

            rem = N % 10; // geting last num
            N = N / 10; // reducing the number after removing the last num
            ans = rem * mul + ans; // add the ans
            mul = mul * 2; // to add raise to power : 2 ^ i
        }
        System.out.print(ans);

    }

    static void toBinary(int N) {
        //Write your code here

        int rem = 0;
        int ans = 0, mul = 1;
        ;

        while (N > 0) {

            rem = N % 2;// getting remainder
            N = N / 2; // Quotient after getting remainder
            ans = rem * mul + ans; // add the ans : mul is 10 ^i
            mul = mul * 10;  // to add raise to power : 10 ^ i

        }
        System.out.print(ans);

    }
}
