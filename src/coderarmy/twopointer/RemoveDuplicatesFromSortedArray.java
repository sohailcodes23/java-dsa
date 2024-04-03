package coderarmy.twopointer;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("ANS " + removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {

//        TC=>O(N)
//        SC=>O(1)

        int n = nums.length;
        int start = 0; // always the unique element
        int end = start + 1; // unique element finder
        int k = 0;
        while (end < n) {
            if (nums[start] == nums[end]) {// so if start==end, end will move forward till it finds a new unique element
                end++;
            } else {// once a new unique element is found, here start != end, so start will move forward so that new unique element can be assigned to the next index
                start++;
                k++;
                nums[start] = nums[end];
            }
        }
        return k + 1;//bcz elements start from 0, so if unique element goes till 4, total elements will be 0,1,2,3,4
    }
}
