package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DuplicateInArray {


    public static void main(String[] args) {
//        int array[] = {1, 2, 4, 3, 4, 5};
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(1, 2, 4, 3, 5, 4));
        System.out.println("ANS " + findDuplicate(integers));
    }

    public static int findDuplicate(ArrayList<Integer> arr) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            hashMap.put(arr.get(i), hashMap.getOrDefault(arr.get(i), 0) + 1);
        }

        Integer maxKey = null;
        Integer maxValue = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (maxValue < map.getValue()) {
                maxValue = map.getValue();
                maxKey = map.getKey();
            }
        }


        return maxKey;
    }
}
