package coderarmy.string;

public class IndexOfFirstOccurrence {

    public static void main(String[] args) {
        String haystack = "absdd";

        String needle = "sad";

        System.out.println("ANS " + strStr_Better(haystack, needle));
    }

    public static int strStr_Better(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= (n - m); i++) { // n-m, bcz if at the end n pending values< m, than there is no need to check the rest of the value
            String sub = haystack.substring(i, i + m);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr_Brute(String haystack, String needle) {

//        TC=> O(N*M)
        char[] needleArray = needle.toCharArray();
        char[] haystackArray = haystack.toCharArray();

        if (needleArray.length == haystackArray.length && haystack.equals(needle)) {// both are 'a' and 'a', than just check it
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= (haystackArray.length - needleArray.length); i++) {//(haystackArray.length - needleArray.length) bcz if the needle is 3 and pending values in haystack is less than 3, than no point of checking
            for (int j = 0; j < needleArray.length; j++) {

                if (haystackArray[i + j] != needleArray[j]) {// i + j, 0+1=1, so 1st element of i and 1 element of j
                    // if not equal than it's not worth it to check future, update the i and check next elements, that why break
                    break;
                }

                if (j == needleArray.length - 1) {// if j is at the end that means all the element has been matched
                    // if i ends before j has ended than there was no needle in the haystack
                    return i;
                }
            }
        }

        return -1;
    }
}
