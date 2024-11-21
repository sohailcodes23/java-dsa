package dsa_buddies;

public class Pattern {


    public static void main(String[] args) {

        int n = 5;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++){
                System.out.print((char)('A'+j));
            }
            System.out.println();
        }

//        for(int i=0;i<n-i-1;i++){
//            System.out.print("_");
//            for(int j=0;j<2*i+1;j++){
//                System.out.printf("*");
//            }
//            System.out.println();
//        }

//        int n = 5;
//        for (int i = 0; i < n; i++) {
//
//            for (int j = 0; j < n - i - 1; j++) {
//                System.out.printf("_");
//            }
//
//            for (int j = 0; j < 2 * i + 1; j++) {
//                System.out.printf("*");
//            }
//            System.out.println();
//        }
    }
}
