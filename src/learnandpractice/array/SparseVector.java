package learnandpractice.array;

import java.util.HashMap;

public class SparseVector {
    // Your SparseVector object will be instantiated and called as such:
    // SparseVector v1(nums1);
    // SparseVector v2(nums2);
    // int ans = v1.dotProduct(v2);
    HashMap<Integer, Integer> map;

    SparseVector(int[] nums) {
        int n = nums.length;
        // do intialization here
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        // write your code here
        int sum = 0;

        for (int index : this.map.keySet()) {
            if (vec.map.containsKey(index)) {
                sum = sum + (this.map.get(index) * vec.map.get(index));
            }
        }

        return sum;
    }
}