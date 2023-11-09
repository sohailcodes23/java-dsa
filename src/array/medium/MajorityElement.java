package array.medium;

import java.util.HashMap;
import java.util.Map;


// MajorityElement means the element occurences in the array should be more than N/2
//Moore's Voting Algorithm :
// 1. Take the first element and assign to current element and increment the count
// 2. if the next elements in the array are same as the current element than increment, else decrement
// 3. if the count == 0 than assign the next element as the current element and check the rest of the element
// 4. after the loop is ended. Reiterate the whole loop and check the current element value occurrence in the array
// 5. if the current element occurence > N/2, than that element is the majority element
public class MajorityElement {

    public static void main(String[] args) {
        int array[] = {2, 2, 1, 3, 2, 2, 3, 1, 2};

        System.out.println(majorityElement_Optimal(array));
    }


    // Optimal
    //Moore's Voting Algorithm
    public static int majorityElement_Optimal(int[] v) {
        // TC=> O(N), If problem says that there is a majority element. Bcz than we don't need to check the TC for 2nd loop
        // TC=> O(2N), If problem says it might or not might have majority element. Bcz than we will need to add 2nd loop and tak it's TC as well
        // SC=> O(1), constant
        int element = -1;
        int count = 0;
        //  TC 1=> O(N)
        for (int i = 0; i < v.length; i++) {
            if (count == 0) {
                element = v[i];
                count++;
            } else if (element == v[i]) {
                count++;
            } else {
                count--;
            }
        }

        //  TC 2=> O(N)
        // if the problem states that it might or not might have majority element only than you need to iterate and check
        int elementCounter = 0;
        for (int i = 0; i < v.length; i++) {
            if (element == v[i]) {
                elementCounter++;
            }
        }

        if (elementCounter > v.length / 2) {
            return element;
        } else {
            return -1;
        }

    }

    // Better
    public static int majorityElement_Brute(int[] v) {
//        TC=> O(N) + O(N)= O(2N), since Hashmap is unordered map, if there is ordered map than the TC=> O(N logN)
//        SC=> O(N), worst case if all the elements are uniques all the elements will be added in the map, so O(N)
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //TC 1 => O(N), since Hashmap is unordered map, if there is ordered map than the TC=> O(N logN)
        for (int i = 0; i < v.length; i++) {
            hashMap.put(v[i], hashMap.getOrDefault(v[i], 0) + 1);

        }

        //TC 2 => O(N), since Hashmap is unordered map, if there is ordered map than the TC=> O(N logN)
        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (set.getValue() > (v.length / 2)) {
                return set.getKey();
            }
        }

        return -1;
    }

    // Brute is linear algo
}
