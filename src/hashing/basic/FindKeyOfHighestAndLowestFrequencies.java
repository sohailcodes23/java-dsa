package hashing.basic;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FindKeyOfHighestAndLowestFrequencies {
    public static void main(String[] args) {
        integerHashingUsingMapOptimised();
    }

    static void integerHashingUsingMapOptimised() {

        // take the array length
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];

        HashMap<Integer, Integer> hash = new HashMap<>(); // Here whatever problem states the maximum value in array are allowed add one, like if max size of array can be 12 than write 13, if 20 than 21,  maxValue +1
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();

            // Updating hashmap
            int key = array[i];
            int freq = 0;
            if (hash.containsKey(key)) {
                freq = hash.get(key);
            }
            freq++;
            hash.put(key, freq);
        }


        // Approach 1
        int maxKey = 0;
        int minKey = 0;
        int maxValue = 0;
        int minValue = n; // this is assigned as n because during comparison It the highest number to compare, only than it can assign a smaller number
        for (Entry<Integer, Integer> it : hash.entrySet()) {
            int count = it.getValue();
            int key = it.getKey();
            if (count > maxValue) {
                maxValue = count;
                maxKey = key;
            }
            System.out.println("CC " + count + " " + minValue);
            if (count < minValue) {
                minValue = count;
                minKey = key;
            }
        }
        System.out.println("HIGHEST " + maxKey + " " + maxValue);
        System.out.println("Lowest " + minKey + " " + minValue);

        // Approach 2
//        int highestFrequencyKey = Collections.max(hash.values());
//        int lowestFrequencyKey = Collections.min(hash.values());
//        for (Entry<Integer, Integer> it : hash.entrySet()) {
//            System.out.println(it.getKey() + "->" + it.getValue());
//
//            if (it.getValue() == highestFrequencyKey) {
////                System.out.println("HIGHEST " + it.getKey() + " " + it.getValue());
//            }
//
//            if (it.getValue() == lowestFrequencyKey) {
////                System.out.println("Lowest " + it.getKey() + " " + it.getValue());
//            }
//
//            System.out.println("ANS " + it.getKey() + "->" + it.getValue());
//        }

    }

}
