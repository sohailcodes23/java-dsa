package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(2, 1, 5, 4, 3, 0, 0));

//        int[] a = {2, 1, 5, 4, 3, 0, 0};
        int[] a = {1, 2, 3};
        nextPermutation_OptimalForArray(a);
        System.out.println("ANS " + Arrays.toString(a));
    }

    static List<Integer> nextPermutation_OptimalForList(List<Integer> array) {


        int n = array.size();
        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (array.get(i) < array.get(i + 1)) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            Collections.reverse(array);
            return array;
        }

        for (int i = n - 1; i > breakPoint; i--) {

            if (array.get(i) > array.get(breakPoint)) {
                int temp = array.get(breakPoint);
                array.set(breakPoint, array.get(i));
                array.set(i, temp);

                break;
            }
        }

        List<Integer> sublist = array.subList(breakPoint + 1, n);

        Collections.reverse(sublist);

        return array;
    }

    static void nextPermutation_OptimalForArray(int[] nums) {
        List<Integer> array = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        int n = array.size();
        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (array.get(i) < array.get(i + 1)) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            Collections.reverse(array);

            for (int i = 0; i < array.size(); i++) {
                nums[i] = array.get(i);
            }
        } else {

            for (int i = n - 1; i > breakPoint; i--) {

                if (array.get(i) > array.get(breakPoint)) {
                    int temp = array.get(breakPoint);
                    array.set(breakPoint, array.get(i));
                    array.set(i, temp);

                    break;
                }
            }

            List<Integer> sublist = array.subList(breakPoint + 1, n);

            Collections.reverse(sublist);

            for (int i = 0; i < array.size(); i++) {
                nums[i] = array.get(i);
            }
        }
    }
}
