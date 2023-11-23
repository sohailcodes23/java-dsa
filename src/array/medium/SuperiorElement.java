package array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperiorElement {

    public static void main(String[] args) {

//        int a[] = {1, 2, 3, 2};
        int a[] = {10, 22, 12, 3, 0, 6};
//        int a[] = {1, 2, 2, 1};
//        int a[] = {5, 4, 3};
//        int a[] = {
//                142, 145, 41, 13, 41
//        };
//        int a[] = {
//                187, 64, 133, 62, 49, 163, 50, 115, 42, 65, 60, 49, 32, 87, 141, 142, 146, 159
//        };
//        List<Integer> integers = superiorElements_Brute(a);
        List<Integer> integers = superiorElements_Optimal(a);
        System.out.println("ANS " + integers);
    }

    public static List<Integer> superiorElements_Optimal(int[] a) {
//        TC=> O(N)
//        Final SC=> O(NlogN)
        List<Integer> superiorElements = new ArrayList<>(); // SC=> O(N), just to store the result
        int maxNo = Integer.MIN_VALUE;
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) { // we are checking from back, since the elements will be in descending order

            if (a[i] > maxNo) { // since the elements will be in the descending order we can check the next element from back and if there is any small numbers than those are not superior elements
                maxNo = a[i];
                superiorElements.add(a[i]);
            }
        }

        // SC=> O(N log N) to sort the elements
        Collections.sort(superiorElements);
        return superiorElements;
    }

    public static List<Integer> superiorElements_Brute(int[] a) {
// 1 4 2 1
        List<Integer> superiorElements = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[i]) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                superiorElements.add(a[i]);
            }
        }

        Collections.sort(superiorElements);
        return superiorElements;
    }
}
