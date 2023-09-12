package logicBuilding;

// P: 22,20,7
public class Patterns {

    public static void main(String[] args) {
        p22(4);
    }


    // IMP // Recheck
    //https://www.youtube.com/watch?v=tNm_NNSB3_w  1:15:00
    static void p22(int n) {
//n= 4 || 6

        //4444444
        //4333334
        //4322234
        //4321234
        //4322234
        //4333334
        //4444444

        int loopRun = 2 * n - 1;
        for (int i = 0; i < loopRun; i++) {

            for (int j = 0; j < loopRun; j++) {
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int down = (2 * n - 2) - i;

                int value = Math.min(Math.min(top, down), Math.min(left, right));
                int finalValue = n - value;
                System.out.print(finalValue);
            }
            System.out.println();

        }
    }

    static void p21Optimised(int n) {
//n= 4 || 6

        //******
        //*    *
        //*    *
        //*    *
        //*    *
        //******
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                // n-1 bcz index starts from 0

                if (i == 0 || j == 0 || i == (n - 1) || j == (n - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();

        }
    }

    // OWN working for 4 // not working for all n value like 6,8
    static void p21(int n) {
        // n=4

        //****
        //*__*
        //*__*
        //****

        for (int i = 1; i <= n; i++) {
            int initialStar = n / 2;
            if (i == n) {
                initialStar = n / 2;
            } else if (i >= initialStar) {
                initialStar = 1;
            }
            // star
            for (int j = 1; j <= initialStar; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 1; j <= n - (2 * initialStar); j++) {
                System.out.print("_");
            }
            // star
            for (int j = 1; j <= initialStar; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //IMP
    static void p20(int n) {
//       n=5

//*        *
//**      **
//***    ***
//****  ****
//**********
//****  ****
//***    ***
//**      **
//*        *

//        the outer loop will be 2n-1
        int initialSpace = 2 * n - 2;
        for (int i = 1; i <= (2 * n - 1); i++) {
            int stars = i; // bcz the number of stars is same as i
            // to handle reverse of stars
            if (i > n) {
                stars = 2 * n - i;
            }
            // star
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 1; j <= initialSpace; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
            if (i < n) {
                initialSpace -= 2;
            } else {
                initialSpace += 2;
            }
        }
    }


    static void p19Optimised(int n) {
//**********
//****__****
//***____***
//**______**
//*________*
//*________*
//**______**
//***____***
//****__****
//**********

        int halfPartN = n / 2;
        int initialUperHalfSpace = 0;
        // UPPER half of the pattern
        for (int i = 0; i < halfPartN; i++) {
            //  left half of the upper pattern
            // star
            for (int j = 1; j <= halfPartN - i; j++) {
                System.out.print("*");
            }

            //space
            for (int j = 0; j < initialUperHalfSpace; j++) {
                System.out.print("_");
            }

            //  right half of the upper pattern
            // star
            for (int j = 1; j <= halfPartN - i; j++) {
                System.out.print("*");
            }
            initialUperHalfSpace += 2;
            System.out.println();
        }

        int initialLowerHalfSpace = n - 2;
        // LOWER half of the pattern
        for (int i = 1; i <= halfPartN; i++) {
            //star //  left half of the lower pattern
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < initialLowerHalfSpace; j++) {
                System.out.print("_");
            }

            //star //  right half of the lower pattern
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            initialLowerHalfSpace -= 2;
            System.out.println();
        }

    }


    //OWN
    static void p19(int n) {
//**********
//****__****
//***____***
//**______**
//*________*
//*________*
//**______**
//***____***
//****__****
//**********

        int halfPartN = n / 2;
        // UPPER half of the pattern
        for (int i = halfPartN; i >= 1; i--) {
            //  left half of the upper pattern
            // star
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }

            //space
            for (int j = 0; j < 2 * (halfPartN - i); j++) {
                System.out.print("_");
            }

            //  right half of the upper pattern
            // star
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // LOWER half of the pattern
        for (int i = 1; i <= halfPartN; i++) {
            //star //  left half of the lower pattern
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < n - (2 * i); j++) {
                System.out.print("_");
            }

            //star //  right half of the lower pattern
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }

    }


    //OWN
    static void p18(int n) {
//E
//DE
//CDE
//BCDE
//ABCDE
        for (int i = 0; i < n; i++) {

            char start = (char) ('A' + (n - 1));
            char value = (char) (start - i); // Imp
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (value + j));
            }
            System.out.println();
        }

    }


    static void p17(int n) {

        for (int i = 0; i < n; i++) {
            //space
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }


            char ch = 'A';
            int breakPoint = (2 * i + 1) / 2; // this is only to reverse the character values
            for (int j = 0; j < 2 * i + 1; j++) { // 2 * i + 1 to create the triangle pattern.
                System.out.print(ch);

                //IMP to reverse the characters
                if (j < breakPoint) {
                    ch++;
                } else {
                    ch--;
                }
            }

            //space
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }

            System.out.println();
        }

//        for (int r = 0; r < n; r++) {
//            // space
//            for (int j = 0; j < n - r - 1; j++) {
//                System.out.print(" ");
//            }
//
//            // star
//            for (int j = 0; j < 2 * r + 1; j++) {
//                System.out.print("A");
//            }
//
//            // space
//            for (int j = 0; j < n - r - 1; j++) {
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
    }


    static void p16(int n) {
        //A
        //BB
        //CCC
        //DDDD
        //EEEEE

        for (int r = 0; r < n; r++) {

            char ch = (char) ('A' + r);
            for (char c = 0; c <= r; c++) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    static void p15Optimised(int n) {
//ABCDE
//ABCD
//ABC
//AB
//A
        for (int r = 0; r < n; r++) {
            char start = 'A';
            // Here (n - r - 1) is used because 'A' is already the start, now in ABCDE, It will be A+4(characters) that's y n-1, to decrease we are using r as well so it is (n-1-r)
            for (char j = start; j <= (start + (n - r - 1)); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void p15(int n) {

        for (int r = 0; r < n; r++) {
            char start = 'A';
            for (char j = start; j < (start + (n - r)); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void rightAngleTriangleP14Optimised(int n) {
//A
//AB
//ABC
//ABCD
//ABCDE
        for (int r = 0; r < n; r++) {
            //Here char value is incremented
            for (char c = 'A'; c <= 'A' + r; c++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //OWN
    static void rightAngleTriangleP14() {
        char[] array = {'A', 'B', 'C', 'D'};
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < r; c++) {
                System.out.print(array[c]);
            }
            System.out.println();
        }
    }

    //Own
    static void p13(int n) {
        int tempNo = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(tempNo + " ");
                tempNo++;
            }
            System.out.println();

        }

    }


    static void p12(int n) {
//1      1
//12    21
//123  321
//12344321

        for (int i = 1; i <= n; i++) {
            int space = 2 * (n - i);
            // first half of number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            //space : we create a formula based on patter
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            // second half of number
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }

    static void p11(int n) {
//1
//01
//101
//0101
        int start = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                start = 1;
            } else {
                start = 0;
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(start);

                // to flip the values of start to 0 and 1
                start = 1 - start;
            }
            System.out.println();
        }
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
    static void rightAngleTriangle(int input) {
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
