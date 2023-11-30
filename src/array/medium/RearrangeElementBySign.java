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
//        int array[] = {-2, -3, 7, 5, 1, 4, 8, -3};
        int array[] = {3, 1, -2, -5, 2, -4};
//        int array[] = {-3, 1, 3, 2, -5, -4};

//        rearrangeElementBySign_Optimal(array);
//        System.out.println("ANS " + Arrays.toString(rearrangeElementBySign_Optimal(array)));
//        System.out.println("ANS " + Arrays.toString(rearrangeElementBySign_Optimalv2(array)));

        System.out.println("ANS " + Arrays.toString(rearrangeElementBySign_Optimalv2(array)));
    }


    static int[] rearrangeElementBySign_Optimalv2(int a[]) {
        // Final TC => O(N) + O(N) = O(2N)
        // SC +> O(N)

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

// TC => O(N)
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                positives.add(a[i]);
            } else {
                negatives.add(a[i]);
            }
        }

        if (positives.size() > negatives.size()) {

            for (int i = 0; i < negatives.size(); i++) { // negatives.size() will be the lower size of array, so that all the negative values are added in the array

                a[2 * i] = positives.get(i);
                a[2 * i + 1] = negatives.get(i);
            }

            int startIndex = negatives.size() * 2;

            for (int i = negatives.size(); i < positives.size(); i++) { // to add rest pending elements

                a[startIndex] = positives.get(i);
                startIndex++;
            }
        } else {


            for (int i = 0; i < positives.size(); i++) { // positives.size() will be the lower size of array, so that all the positive values are added in the array

                a[2 * i] = positives.get(i);
                a[2 * i + 1] = negatives.get(i);
            }

            int startIndex = positives.size() * 2;

            for (int i = positives.size(); i < negatives.size(); i++) { // to add rest pending elements

                a[startIndex] = negatives.get(i);
                startIndex++;
            }

        }

        return a;
    }

    static int[] rearrangeElementBySign_Optimal(int nums[]) {
        // Final TC => O(N)
        // SC => O(N)
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
// Final TC => O(N) + O(N/2)
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


    // Code studio took the ans but the code doesn't return the required answer
    static int[] rearrangeElementBySign_(int a[]) {
        // Final TC => O(N)
        // SC => O(N)
        int positiveIndex = 0;
        int negativeIndex = 1;
        int ans[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {

            if (a[i] > 0) {
                ans[positiveIndex] = a[i];
                positiveIndex = (positiveIndex + 2) >= a.length ? positiveIndex + 1 : positiveIndex + 2; // this is added so if the +ves and -ves are not equal it will assign the values at the end f the array
            } else {
                ans[negativeIndex] = a[i];
                int min = a.length - negativeIndex;
                System.out.println(negativeIndex + " M " + min);
                negativeIndex = (negativeIndex + 2) >= a.length ? negativeIndex + 1 : negativeIndex + 2;
                System.out.println("N " + negativeIndex);

            }
        }
        return ans;
    }

}
