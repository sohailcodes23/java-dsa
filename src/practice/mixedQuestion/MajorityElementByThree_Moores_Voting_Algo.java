package practice.mixedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// How many ans will be there in result, is decided based on n/3.
// So if n=8, 8/3=2, now if elemenst should occur more than 2 time, so if we take 3 elements + 3 elem..+ 3 elem..= it will be more than n i.e. 8
public class MajorityElementByThree_Moores_Voting_Algo {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(1, 2, 4, 4, 3, 4));

        int[] arra = {1, 2, 2, 2, 4, 4, 3, 4};
//        int[] arra = {2, 2};

//        System.out.printf("ANS " + majorityElementII_Brute(integers));
        System.out.printf("ANS " + majorityElementII_Betterv2(arra));
    }

    public static ArrayList<Integer> majorityElementII_Optimal(int[] arr) {

        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int toCheck = (n / 3) + 1; // adding +1 to get the minimum number to be majority
        // NOTE : these count are not actual majority elements, bcz it is calculated based on + and --
        // Actual count is done below
        for (int i = 0; i < n; i++) { // loop to get the elements and element count

            if (count1 == 0
                    && ele2 != arr[i]) { // ele2 != arr[i] to avoid count the same element that is assigned to ele2
                ele1 = arr[i];
                count1++;
            } else if (count2 == 0
                    && ele2 != arr[i]) {
                ele2 = arr[i];
                count2++;
            } else if (arr[i] == ele1) {
                count1++;
            } else if (arr[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }


        // Actual count of elements
        //checking the elements
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (ele1 == arr[i]) {
                count1++;
            }

            if (ele2 == arr[i]) {
                count2++;
            }
        }

        if (count1 >= toCheck) {
            result.add(ele1);
        }


        if (count2 >= toCheck && ele1!=ele2) { // just to be double to sure && ele1!=ele2, to be sure for {2,2} cases
            result.add(ele2);
        }

        return result;
    }

    public static ArrayList<Integer> majorityElementII_Betterv2(int[] arr) {
//        TC=> O(N)
        //        SC=> O(N)
        int n = arr.length;
        int toCheck = (n / 3) + 1;// update : just i case it's 0 so to handle that +1, you need to change below logic as well
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println("DD " + toCheck);
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);

            if (hashMap.get(arr[i]) == toCheck) { // update : since +1 added to toCheck, just need to check ==
                result.add(arr[i]);
            }
        }


        return result;
    }

    public static ArrayList<Integer> majorityElementII_Better(int[] arr) {
//        TC=> O(2N)
//        SC=> O(N)
        int n = arr.length;
        int toCheck = n / 3;
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {

            if (integerIntegerEntry.getValue() > toCheck) {
                result.add(integerIntegerEntry.getKey());
            }
        }

        return result;
    }

    public static ArrayList<Integer> majorityElementII_Brutev2(int[] arr) {
        int n = arr.length;
        int toCheck = n / 3;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int currentElement = arr[i];
            int count = 0;

            if (result.isEmpty() // if you don't add this, it will cause exception at result.get(0)
                    || result.get(0) != arr[i]) {
                for (int j = 0; j < n; j++) {

                    if (currentElement == arr[j]) {
                        count++;
                    }
                }

                if (count >= toCheck) {
                    result.add(arr[i]);
                }


                if (result.size() == 2) { // bcz we know that only 2 elements will be there in ans
                    break;
                }
            }
        }

        return result;

    }

    public static ArrayList<Integer> majorityElementII_Brute(ArrayList<Integer> arr) {

        int n = arr.size();
        int toCheck = n / 3;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int currentElement = arr.get(i);
            int count = 0;

            for (int j = 0; j < n; j++) {

                if (currentElement == arr.get(j)) {
                    count++;
                }
            }

            if (count >= toCheck && !result.contains(arr.get(i))) {
                result.add(arr.get(i));
            }
        }

        return result;

    }
}
