package dsa_buddies.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Moore's Voting Algorithm
public class MajorityElementTwo {

    public static void main(String[] args) {

//        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("AA " + findMajority_Better(arr));
    }

//    public List<Integer> findMajority(int[] nums) {
//
//    }


    public static List<Integer> findMajority_Better(int[] nums) {
        //  Can be done using Hashmap, which can be used to keep the count and it 's sorted so will get the increasing order

        int n = nums.length;
        int occ = (n / 3) + 1;// +1 bcz we want more than n/3
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(occ);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

//            if (map.get(nums[i]) == occ) {
//                System.out.println(map.get(nums[i]));
//                integers.add(nums[i]);
//            }
        }

        // bcz we want it in increasing order(Asc)
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= occ) {
                integers.add(entry.getKey());
            }
        }

        return integers;
    }

    public static List<Integer> findMajority_Brute(int[] nums) {
        int n = nums.length;
        int occurence = n / 3;
        List<Integer> majority = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currOcc = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    currOcc++;
                }
            }
            if (currOcc > occurence && !majority.contains(nums[i])) {
//                tempArr[nums[i]];
                majority.add(nums[i]);
            }
        }

        return majority;
    }
}
