package array.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Here in array, there will be positive and negative numbers
// +ves will be N/2
// -ves will be N/2
// RearrangeElementBySign basically means +element, -element,+element, -element... so on, The order is maintained like if array had={1,-5,3,-2}. SO while rearranging the -ve values should be like -5,+ve,-2. Same goes for +ve as well
public class RearrangeElementBySign {

    public static void main(String[] args) {
        int array[] = {-2, -3, 4, 5};
//        int array[] = {3, 1, -2, -5, 2, -4};
//        int array[] = {-3, 1, 3, 2, -5, -4};

//        rearrangeElementBySign_Optimal(array);
        System.out.println("ANS " + Arrays.toString(rearrangeElementBySign_Optimalv2(array)));

        rearrangeElementBySign_Brute(array);
        System.out.println("ANS " + Arrays.toString(array));
    }


    static int[] rearrangeElementBySign_Optimalv2(int nums[]) {
        // Final TC => O(N)
        // SC +> O(N)
        int positiveIndex = 0;
        int negative = positiveIndex + 1;
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans[positiveIndex] = nums[i];
                positiveIndex = positiveIndex + 2;
            } else {
                ans[negative] = nums[i];
                negative = negative + 2;
            }
        }

        return ans;
    }

    static void rearrangeElementBySign_Brute(int array[]) {
// FInal TC => O(N) + O(N/2)
        // SC +> O(N)

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

// TC => O(N)
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positives.add(array[i]);
            } else {
                negatives.add(array[i]);
            }
        }

        // TC => O(N/2)
        for (int i = 0; i < array.length / 2; i++) { // array.length / 2 bcz during 2*i it will handle the rest of the indexes

            array[2 * i] = positives.get(i);
            array[2 * i + 1] = negatives.get(i);
        }
    }
}
