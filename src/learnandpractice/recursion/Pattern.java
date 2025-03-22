package learnandpractice.recursion;

public class Pattern {

    public static void main(String[] args) {
        pattern2(4);
    }

    static void pattern2(int n) {
//        QQ:
//*
//**
//***
//****
        if (n <= 0) {
            return;
        }
        pattern2(n - 1);
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void pattern1(int n) {
//        QQ:
//****
//***
//**
//*
        if (n <= 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
        pattern1(n - 1);
    }
}
