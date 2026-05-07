package own;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindNegativeNumber {

    public static void main(String[] args) {
        //Given a list of transaction amounts, remove all negative values. Write the code.


    }

    //    TC=>O(N)
//
//    SC=>O(N)
    private List<Integer> removeNegative(List<Integer> input) {

        //Streams
        input.stream()
                .filter(i -> i < 0)
                .collect(Collectors.toList());
//        return input;

        //lamda
        input.removeIf(i -> i < 0);
//        return input;

        //Brute
        List<Integer> ans = new ArrayList<>();
        for (Integer i : input) {
            if (i >= 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
