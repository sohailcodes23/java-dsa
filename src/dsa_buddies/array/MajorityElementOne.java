package dsa_buddies.array;

//Moore's Voting Algorithm
public class MajorityElementOne {

    public static void main(String[] args) {

//        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("AA " + majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
//        TC==> O(N)
        int n = nums.length;

        int count = 0;
        int currentElement = -1;


        for (int i = 0; i < n; i++) {
            if (count == 0) {
                currentElement = nums[i];
            }

            if (nums[i] == currentElement) {
                count++;
            } else {
                count--;
            }
        }


        return currentElement;//Assume that the majority element always exists in the array, else we have to loop the array and check if it's occurrence is more than n/2
    }


    //    public static int findMajority_Better(int[] nums) { : Can be done using Hashmap, which can be used to keep the count and it's sorted so will get the increasing order

}
