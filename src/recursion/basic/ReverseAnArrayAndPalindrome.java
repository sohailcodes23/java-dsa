package recursion.basic;

//https://www.youtube.com/watch?v=twuC1F6gLI8
public class ReverseAnArrayAndPalindrome {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {1, 3, 5, 7, 9};
//        System.out.println("ARR " + Arrays.toString(reverseAnArrayOptimised(arr, 0)));
        String value = "MADSM";
        char[] charArray = value.toCharArray();
//        checkStringIsPalindrome(charArray, value, 0);
        System.out.println("CC " + checkStringIsPalindromeOptimised(charArray, 0));
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


    // with single variables like i and (n-i-1)
    static int[] reverseAnArrayOptimised(int[] originalArray, int i) {
        int n = originalArray.length;
//        if (i >= (n - i - 1)) {
        if (i >= (n / 2)) { // bcz during swapping the functions complete st the middle of the array
            return originalArray;
        }

        swapNo(originalArray, i, (n - i - 1));
        reverseAnArrayOptimised(originalArray, i + 1);

        return originalArray;
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
