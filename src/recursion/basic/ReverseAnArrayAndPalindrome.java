package recursion.basic;

import java.util.Arrays;

//https://www.youtube.com/watch?v=twuC1F6gLI8
public class ReverseAnArrayAndPalindrome {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {3, 1, 1, 7, 4, 2, 6, 11};
//        8
//        3 1 1 7 4 2 6 11


        System.out.println("ARR " + Arrays.toString(reverseArray(8, arr)));
        String value = "MADSM";
        char[] charArray = value.toCharArray();
//        checkStringIsPalindrome(charArray, value, 0);
        System.out.println("CC " + checkStringIsPalindromeOptimised(charArray, 0));
    }

    //1. https://www.codingninjas.com/studio/problems/reverse-an-array_8365444?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
    public static int[] reverseArray(int n, int[] nums) {
        return recursion(nums, 0, n - 1);
    }

    public static int[] recursion(int[] nums, int left, int right) {
        if (left >= right) return nums;

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
        return recursion(nums, left + 1, right - 1);
    }

    // 2. https://www.codingninjas.com/studio/problems/check-palindrome-recursive_624386?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
    public static boolean isPalindrome(String str) {
//        String str = "MADSM";
        char[] charArray = str.toCharArray();
//        checkStringIsPalindrome(charArray, str, 0);
        return checkStringIsPalindromeOptimised(charArray, 0);
    }

    // Without swap, if it will be palindrome than both the sides will be identical. So the recursion will go till n/2. But if any values are not same on both side than it should not go till n/2.
    //EX=> 'MADAM' when index l=0 and r=n-1 i.e.(4), both the values are 'M'
    //EX=> 'MADSM' when index l=1 and r=n-1 i.e.(3), both the values are not a 'A', so it won't check all the value, it will just return false i.e. Not a palindrome
    static boolean checkStringIsPalindromeOptimised(char[] charArray, int i) {
//        TC => O(n/2)
//        SC => O(n/2)
        int n = charArray.length;
        if (i >= n / 2) {
            return true; // check above comments to understand this true logic
        }

        if (charArray[i] != charArray[(n - i - 1)]) {
            return false;
        }

        return checkStringIsPalindromeOptimised(charArray, i + 1);
    }

    // Brute force, using swap
    static void checkStringIsPalindrome(char[] charArray, String originalValue, int i) {
        int n = charArray.length;
        if (i >= n / 2) {
            if (originalValue.equals(String.valueOf(charArray))) {
                System.out.println("It's palindrome");
            } else {
                System.out.println("Not a palindrome");
            }
            return;
        }
        swapChar(charArray, i, (n - i - 1));

        // NOTE : i+1
        checkStringIsPalindrome(charArray, originalValue, i + 1);
    }

    static void swapChar(char[] arr, int l, int r) {
        char tempValue = arr[l];
        arr[l] = arr[r];
        arr[r] = tempValue;
    }


    // with single variables like n and (n-n-1)
    static int[] reverseAnArrayOptimised(int[] nums, int n) {
        int lengthOfArray = nums.length;
//        if (n >= (length - n - 1)) {
        if (n >= (lengthOfArray / 2)) { // bcz during swapping the functions complete st the middle of the array
            return nums;
        }

        swapNo(nums, n, (lengthOfArray - n - 1));
        reverseAnArrayOptimised(nums, n + 1);

        return nums;
    }


    // with multiple variables like l and r
    static int[] reverseAnArray(int[] originalArray, int l, int r) {

        if (l >= r) {
            return originalArray;
        }

        swapNo(originalArray, l, r);
        reverseAnArray(originalArray, l + 1, r - 1);

        return originalArray;
    }

    static void swapNo(int[] originalArray, int l, int r) {
        int tempValue = originalArray[l];
        originalArray[l] = originalArray[r];
        originalArray[r] = tempValue;
    }

}
