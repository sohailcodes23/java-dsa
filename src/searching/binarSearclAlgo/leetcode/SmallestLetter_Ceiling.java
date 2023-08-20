package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class SmallestLetter_Ceiling {

    // Middle element is equal to target : this condition is not allowed
    // The text wrap around means, if there are no greater element in the array than the targets, return the first element of the array
    public static void main(String[] args) {

//        char[] sortedArray = {'a', 'b', 'd', 'g', 'i'};
        char[] sortedArray = {'c', 'f', 'j'};
//        char[] sortedArray = {'x', 'x', 'y', 'y'};
        System.out.println("ANS " + binarySearch(sortedArray, 'z'));
    }

    /// OWN CODE
    static char binarySearch(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        int middleIndex = 0;
        while (start <= end) {

            middleIndex = start + (end - start) / 2;
            int middleElement = letters[middleIndex];

            if (middleElement > target) {
                end = middleIndex - 1;
            } else {
                // Note keep this as else, bcz if you add the 'else if (middleElement < target) {' it will go to infinite loop
                start = middleIndex + 1;
            }
        }

        // Note
        // Optimised solution by kunal
        int finalIndexOfTarget = start % letters.length;

        return letters[finalIndexOfTarget];
    }
}
