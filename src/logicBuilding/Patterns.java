package logicBuilding;

public class Patterns {

    public static void main(String[] args) {
        p10Optimised(4);

    }

    static void p10Optimised(int n) {
//*
//**
//***
//****
//***
//**
//*
        // Here the number of rows are 2n-1
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;

            // for lower
            if (i > n) {
                stars = 2 * n - i;
            }
            // both based on stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //brute force
    static void p10(int n) {

        //*
        //**
        //***
        //****
        //***
        //**
        //*
        // upper
        for (int i = 0; i < n; i++) {

            //star
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }

            //space
            for (int j = 0; j < n - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
//

        //lower
        // in reverse for loop i >= 1
        int lowerIndex = n - 1;
        for (int i = lowerIndex; i >= 1; i--) {

            // star
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < lowerIndex - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    static void p9(int n) {
//  *
// ***
//*****
//*****
// ***
//  *

        //UpperPattern
        p7(n);
        // Lower Pattern
        p8(n);
    }


    static void p8(int n) {
// *********
// *******
//  *****
//   ***
//    *
        // using formula for stars : 2n - (2i-1), Here (2i-1) gives us the odd, that required in stars. Since it was in decreasing order, we created the 2n - (2i+1)
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < (2 * n - (2 * i + 1)); j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();

        }
    }


    //NOTE
    // p7
    static void p7(int input) {
//    *
//   ***
//  *****
// *******

        // https://www.youtube.com/watch?v=tNm_NNSB3_w 25.01
        for (int i = 0; i < input; i++) {
            // space
            for (int j = 0; j < input - i - 1; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < input - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    //NOTE
    // p6
    static void p6(int input) {
        for (int r = input; r >= 1; r--) {
            for (int c = r; c >= 1; c--) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    //NOTE
    // p5
    static void p5(int input) {
        for (int r = input; r >= 1; r--) {
            for (int c = r; c >= 1; c--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //Note
    // P4
    static void triangleByNoV2(int input) {
        for (int r = 0; r < input; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print(r + 1);
            }
            System.out.println();
        }
    }

    // P3
    static void triangleByNo(int input) {
        for (int r = 0; r < input; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print(c + 1);
            }
            System.out.println();
        }
    }

    // P2
    static void triangle(int input) {
        for (int r = 0; r < input; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // P1
    static void SquareBasedOnInput(int input) {

        //* * * * *
        //* * * * *
        //* * * * *
        //* * * * *
        //* * * * *
        // 4x4
        for (int r = 0; r < input; r++) {
            for (int c = 0; c < input; c++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
