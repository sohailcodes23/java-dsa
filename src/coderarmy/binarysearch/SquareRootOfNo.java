package coderarmy.binarysearch;

public class SquareRootOfNo {

    public static void main(String[] args) {

//        System.out.println("ANS " + mySqrt(100));//10
//        System.out.println("ANS " + mySqrt(80));//8
        System.out.println("ANS " + mySqrt(2147395599));//

    }


    public static int mySqrt(int x) {

        // TC=> O(log N)
        // SC=> O(1)
        if (x < 2) {// x =0 OR x=1,bcz sqrt of O=0 & 1 =1
            return x;
        }
        int start = 1;
        int end = x;
        int mid = 0;
        int ans = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid == x / mid) { // here we need to check the Square of mid(mid * mid == x), but sometime the no. can become very big, so we are moving one mid to right side that's why it became x/mid
                ans = mid;
                return ans;
            } else if (mid < x / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
