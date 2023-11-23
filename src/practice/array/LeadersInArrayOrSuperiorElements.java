package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//LeadersInArray/Superior Elements
public class LeadersInArrayOrSuperiorElements {

    public static void main(String[] args) {


        int array[] = {13, 14, 3, 8, 2};

        ArrayList<Integer> integers = new ArrayList<>();
//        integers.addAll(Arrays.asList(13, 14, 3, 8, 2));
        integers.addAll(Arrays.asList(-2, 9, 10, -7, -1, 0, -3)); // 10 0 -3
        System.out.println("ANS " + findLeaders_Better(integers, integers.size()));
    }

//    Better/Optimal : 2 pointer approach from back


    public static ArrayList<Integer> findLeaders_Better(ArrayList<Integer> elements, int n) {

//        Final TC=> O(2N)
//        SC=> O(N) // for result

        ArrayList<Integer> integers = new ArrayList<>();

        if (n >= 1) {
            integers.add(elements.get(n - 1));
        }
        for (int i = n - 2; i >= 0; i--) { // TC=> O(N)

            if (elements.get(i) > elements.get(i + 1)) {
                integers.add(elements.get(i));
            }
        }
        Collections.reverse(integers); // TC=> O(N) : to reverse the list
        return integers;
    }


    public static ArrayList<Integer> findLeaders_Brute(ArrayList<Integer> elements, int n) {

//        TC=> O(N^2)
//        SC=> O(N) // only for answer else O(N)
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {

            boolean leader = true;
            for (int j = i + 1; j < elements.size(); j++) {

                if (elements.get(i) < elements.get(j)) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                integers.add(elements.get(i));
            }
        }

        return integers;
    }


}
