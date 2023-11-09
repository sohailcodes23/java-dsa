package array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// MajorityElement means the element occurences in the array should be more than N/2
public class MajorityElement {

    public static void main(String[] args) {
        int array[] = {1, 2, 4, 0, -8, -5};

        System.out.println(majorityElement_Brute(array));
    }


    // Better
    public static int majorityElement_Brute(int []v) {
//        TC=> O(N) + O(N)= O(2N), since Hashamp is unordered map, if there is ordered map than the TC=> O(N logN)
//        SC=> O(N), worst case if all the elements are uniques all the elements will be added in the map, so O(N)
        HashMap<Integer,Integer> hashMap= new HashMap<>();

        //TC 1 => O(N), since Hashamp is unordered map, if there is ordered map than the TC=> O(N logN)
        for(int i=0;i<v.length;i++){
            hashMap.put(v[i], hashMap.getOrDefault(v[i], 0)+1);

        }

        //TC 2 => O(N), since Hashamp is unordered map, if there is ordered map than the TC=> O(N logN)
        for(Map.Entry<Integer,Integer> set:hashMap.entrySet()){
            if(set.getValue()>(v.length/2)){
                return set.getKey();
            }
        }

        return -1;
    }

    // Brute is linear algo
}
