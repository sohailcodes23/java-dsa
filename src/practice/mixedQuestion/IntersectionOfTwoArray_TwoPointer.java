package practice.mixedQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArray_TwoPointer {

    public static void main(String[] args) {

        ArrayList<Integer> arra1 = new ArrayList<>();
        arra1.addAll(Arrays.asList(1, 2, 2, 2, 3, 4));
//        arra1.addAll(Arrays.asList(3, 4, 5, 5, 6, 7, 7));

        ArrayList<Integer> arra2 = new ArrayList<>();
        arra2.addAll(Arrays.asList(2, 2, 3, 3, 5, 6));
//        arra2.addAll(Arrays.asList(2, 3, 4, 5, 7));

        System.out.println("ANS " + findArrayIntersection(arra1, arra1.size(), arra2, arra2.size()));
    }

    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {

//        TC=> O(N)
        int i = 0, j = 0;

        ArrayList<Integer> result = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1.get(i).equals(arr2.get(j))) {
                result.add(arr1.get(i));
                i++;
                j++;
            } else if (arr1.get(i) > arr2.get(j)) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }

    public static ArrayList<Integer> findArrayIntersection_Brute(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {

        ArrayList<Integer> result = new ArrayList<>();
        int startPoint = 0;

        for (int i = 0; i < n; i++) {

            int currentElement = arr1.get(i);
            boolean added = false;
            for (int j = startPoint; j < m; j++) {
//                System.out.println("SS "+startPoint);
                if (currentElement == arr2.get(j)) {
                    result.add(arr2.get(j));
                    System.out.println(startPoint + " " + i + " " + j);
                    startPoint = j;
                    added = true;
                    break;
                }
            }
            if (added) {
                startPoint++;
            }
        }

        return result;

    }
}
