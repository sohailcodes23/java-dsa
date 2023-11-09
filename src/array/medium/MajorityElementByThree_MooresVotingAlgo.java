package array.medium;

import java.util.*;


// MajorityElement means the element occurences in the array should be more than N/2
//Moore's Voting Algorithm : Check description in MajorityElementByTwo_MooresVotingAlgo
public class MajorityElementByThree_MooresVotingAlgo {

    public static void main(String[] args) {
//        int array[] = {1,1,1,2,2,2};
        int array[] = {2, 2, 0, 1, 2, 1};

        System.out.println(majorityElement_Optimal(array));
    }

    public static List<Integer> majorityElement_Optimal(int[] v) {

//        TC=> O(2N)
        // SC => O(N)
        int count1 = 0;
        int element1 = -1;
        int count2 = 0;
        int element2 = -1;
        int minimumRequired = (v.length / 3) + 1;
        List<Integer> answer = new ArrayList<>();
        int n = v.length;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != v[i]) {
                count1++;
                element1 = v[i];
            } else if (count2 == 0 && element1 != v[i]) {
                count2++;
                element2 = v[i];
            } else if (element1 == v[i]) {
                count1++;
            } else if (element2 == v[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int eCount1 = 0;
        int eCount2 = 0;
        // manual count
        for (int i = 0; i < v.length; i++) {
            if (v[i] == element1) {
                eCount1++;
            }

            if (v[i] == element2) {
                eCount2++;
            }
        }

        if (eCount1 >= minimumRequired) {
            answer.add(element1);
        }

        if (eCount2 >= minimumRequired) {
            answer.add(element2);
        }

        Collections.sort(answer);

        return answer;
    }


    public static List<Integer> majorityElement_Better2(int[] v) {

//        TC=> O(N)
//        SC=> O(N)
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            int value = hashMap.getOrDefault(v[i], 0);
            if (value < v.length / 3) {
                hashMap.put(v[i], value + 1);
            } else if (!answer.contains(v[i])) {
                answer.add(v[i]);
            }

        }
        Collections.sort(answer); // required in problem to be sorted
        return answer;
    }

    // Better
    public static List<Integer> majorityElement_Better1(int[] v) {
//        TC=> O(N) + O(N)= O(2N), since Hashmap is unordered map, if there is ordered map than the TC=> O(N logN)
//        SC=> O(N), worst case if all the elements are uniques all the elements will be added in the map, so O(N)
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //TC 1 => O(N), since Hashmap is unordered map, if there is ordered map than the TC=> O(N logN)
        for (int i = 0; i < v.length; i++) {
            hashMap.put(v[i], hashMap.getOrDefault(v[i], 0) + 1);
        }

        //TC 2 => O(N), since Hashmap is unordered map, if there is ordered map than the TC=> O(N logN)
        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (set.getValue() > (v.length / 3)) {
                answer.add(set.getKey());
            }
        }

        return answer;
    }

    // Brute is linear algo
}
