package practice.array;

import java.util.*;

public class PositiveNegativePair {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
//        integers.addAll(Arrays.asList(13, 14, 3, 8, 2));
        integers.addAll(Arrays.asList(1, -3, -2, 3, 6, -1)); // -1 1  -3 3
        System.out.println("ANS " + pairs_Brute(integers, integers.size()));
        System.out.println("ANS " + pairs_Better(integers, integers.size()));
        System.out.println("ANS " + pairs_Optimal(integers, integers.size()));
    }

    // Watched
    public static ArrayList<ArrayList<Integer>> pairs_Optimal(ArrayList<Integer> arr, int n) {
//        TC=>O(N)
//        SC=> O(N)
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) { // TC => O(N)
            ArrayList<Integer> newPairs = new ArrayList<>();
            if (integers.contains(-arr.get(i))) {
                newPairs.add(-Math.abs(arr.get(i)));
                newPairs.add(Math.abs(arr.get(i)));
            } else {
                integers.add(arr.get(i));
            }
            if (!newPairs.isEmpty()) {
                arrayLists.add(newPairs);
            }
        }


        return arrayLists;
    }

    // Own
    public static ArrayList<ArrayList<Integer>> pairs_Better(ArrayList<Integer> arr, int n) {
//        TC=>O(2N)
//        SC=> O(N)
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) { // TC => O(N)

            hashMap.put(arr.get(i), i);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) { // TC => O(N)
            int entryKey = entry.getKey();
            if (entryKey < 0) {
                ArrayList<Integer> newPairs = new ArrayList<>();
                int positiveValue = entryKey * -1;

                if (hashMap.containsKey(positiveValue)) {

                    newPairs.add(entry.getKey());
                    newPairs.add(positiveValue);
                }

                if (!newPairs.isEmpty()) {
                    arrayLists.add(newPairs);
                }
            }
        }

        return arrayLists;
    }

    public static ArrayList<ArrayList<Integer>> pairs_Brute(ArrayList<Integer> arr, int n) {

        Collections.sort(arr); // TC=> O(N logN)
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        // TC=> O(N ^ 2)
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                int positiveValue = arr.get(i) * -1;
                ArrayList<Integer> newPairs = new ArrayList<>();
                for (int j = i + 1; j < arr.size(); j++) {
                    if (positiveValue == arr.get(j)) {
                        newPairs.add(arr.get(i));
                        newPairs.add(arr.get(j));
                    }
                }
                if (!newPairs.isEmpty()) {
                    arrayLists.add(newPairs);
                }
            }
        }

        return arrayLists;
    }
}
