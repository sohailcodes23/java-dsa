package recursion.basic;

public class BasicRecursion {
    static int count = 1;

    public static void main(String[] args) {
        basicRecursionV3(5, 5);
    }

    // recursion up to n
    static void basicRecursion(int n) {
        System.out.println("C " + count);
        if (count == n) {
            return;
        }
        count++;
        basicRecursion(n);
    }

    // from 1 to n
    static void basicRecursionV2(int i, int n) {
        System.out.println("C " + i);
        if (i == n) {
            return;
        }
        i++;
        basicRecursionV2(i, n);
    }

    // N to 1
    static void basicRecursionV3(int i, int n) {
        //i=5 and n=5
        if (i < 1) {
            return;
        }
        System.out.println("V " + i);

        basicRecursionV3(i - 1, n);
    }

    // N to 1
    // Not correct, bcz we are changing N value
//    static void basicRecursionV3(int i, int n) {
//        System.out.println("C " + n);
//        if (i == n) {
//            return;
//        }
//        n--;
//        basicRecursionV3(i, n);
//    }
}
