package recursion;


// Print value from opposite function
public class BasicBacktracking {

    public static void main(String[] args) {
        basicBacktrackingV2(1, 3);
    }

    // 1 to N, without using +1
    static void basicBacktracking(int i, int n) {
        //i=3 and n=3
        if (i < 1) {
            return;
        }
        basicBacktracking(i - 1, n);
        System.out.println("V " + i); // Difference from recursion, where the print is written after the recursion.
    }

    // Fixed
    // N to 1, without using -1
    static void basicBacktrackingV2(int i, int n) {
        //i=3 and n=3
        if (i > n) {   // different approach
            return;
        }
        basicBacktrackingV2(i + 1, n);
        System.out.println("V " + i);
    }
}
