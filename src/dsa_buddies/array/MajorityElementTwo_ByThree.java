package dsa_buddies.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Moore's Voting Algorithm
public class MajorityElementTwo_ByThree {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
//        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("AA " + findMajority_Better(arr));
        System.out.println("AA " + findMajority(arr));
    }

    public static List<Integer> findMajority(int[] nums) {
//        TC=> O(2N) ==> O(N)
        int n = nums.length;
        int occ = n / 3;
        List<Integer> integers = new ArrayList<>();
        // there can only be 2 majority element in case of n/3, if we consider more than 2 elements, than we would need more elements in the array
        int count1 = 0;
        int ele1 = 1;
        int count2 = 0;
        int ele2 = 1;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                count1++;
                ele1 = nums[i];
            } else if (count2 == 0 && ele1 != nums[i]) {
                count2++;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        //Need to check that the elements are actually majority element
        for (int num : nums) {
            if (ele1 == num) {
                count1++;
            }

            if (ele2 == num && ele1 != num) {
                count2++;
            }
        }
        if (count1 > occ) {
            integers.add(ele1);
        }
        if (count2 > occ) {
            integers.add(ele2);
        }
        return integers;
    }

    //       GFG To handle: The answer should be returned in an increasing format.
    public static List<Integer> findMajorityV2(int[] nums) {
//        TC=> O(2N) ==> O(N)
        int n = nums.length;
        int occ = n / 3;
        List<Integer> integers = new ArrayList<>();
        // there can only be 2 majority element in case of n/3, if we consider more than 2 elements, than we would need more elements in the array
        int count1 = 0;
        int ele1 = 1;
        int count2 = 0;
        int ele2 = 1;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                count1++;
                ele1 = nums[i];
            } else if (count2 == 0 && ele1 != nums[i]) {
                count2++;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        //Need to check that the elements are actually majority element
        for (int num : nums) {
            if (ele1 == num) {
                count1++;
            }

            if (ele2 == num && ele1 != num) {
                count2++;
            }
        }

//        To handle: The answer should be returned in an increasing format.
        if (count1 > occ && count2 > occ) {
            // Add in increasing order
            if (ele1 < ele2) {
                integers.add(ele1);
                integers.add(ele2);
            } else {
                integers.add(ele2);
                integers.add(ele1);
            }
        } else if (count1 > occ) {
            integers.add(ele1);
        } else if (count2 > occ) {
            integers.add(ele2);
        }
        return integers;
    }


    public static List<Integer> findMajority_Better(int[] nums) {
        //  Can be done using Hashmap, which can be used to keep the count and it 's sorted so will get the increasing order
//        TC=>O(2N) ==> O(N)
//        SC=> O(N)
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
