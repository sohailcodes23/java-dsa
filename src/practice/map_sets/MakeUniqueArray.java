package practice.map_sets;

import java.util.*;

public class MakeUniqueArray {

    public static void main(String[] args) {

        int array[] = {1, 2, 1, 2, 1};
        ArrayList<Integer> integers = new ArrayList<>();
//        integers.addAll(Arrays.asList(1, 2, 1, 3));
        integers.addAll(Arrays.asList(1, 2, 3, 1, 2));
//        integers.addAll(Arrays.asList(1, 2, 3));
        System.out.println("ANS " + minElementsToRemove_Optimal(integers));
    }

    public static int minElementsToRemove_Optimal(ArrayList<Integer> arr) {

        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            integerSet.add(arr.get(i));
        }

        return arr.size() - integerSet.size();// bcz HashSet only save unique values
    }

    public static int minElementsToRemove_Better(ArrayList<Integer> arr) {

//        Tc=> O(2N)
//        SC => O(N)
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < arr.size(); i++) {
            hashMap.put(arr.get(i), hashMap.getOrDefault(arr.get(i), 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                count = (entry.getValue() - 1) + count;

            }
        }

        return count;
    }
}
