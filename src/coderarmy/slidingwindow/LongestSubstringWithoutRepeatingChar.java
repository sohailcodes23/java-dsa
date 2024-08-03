package coderarmy.slidingwindow;

// Using: Sliding Window Protocol
public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String s = "abcdecbeadf";//6
//        String s = "pwwkew";//3

        System.out.println("ANS " + lengthOfLongestSubstring(s));

    }

    // Brute: create all the substrings and than check which is the substring with unique values and it's length (TC=> N^3)
    // Better: 2 pointer approach(TC=> O(N^2)), take 2 pointer from 0 ith, check from 0-(n-1) ith, if there are repeated value (Also save the value of unique chars substring), increment the loop
    // Now check with 1 - (n-1) ith, if there are repeated value (Also save the value of unique chars substring), increment the loop
    // Go on till you are on the n-1 ith, save and compare the max length of unqiue char substring

    public static int lengthOfLongestSubstring(String s) {
//        FINAL TC=> O(N), internal while loop is negligible
//         SC=> O(1), bcz we used array of 256 chars, which is negligible
        int n = s.length();
        int first = 0;
        int second = 0;
        boolean countArray[] = new boolean[256];// to handle all type of char
        int maxLength = 0;
        while (second < n) {// second<n bcz we are moving 2nd pointer till the end, first is only used to mark the repeating elements as false
            int secondCharIndex = s.charAt(second);// got the index of the 2nd pointer char, EX: if the char is 'a', the index will be 97

            while (countArray[secondCharIndex]) {// This will be only true, if we have already found that char before
                //EX: abcdecbeadf : Here the secondCharIndex is at 5ith i.e. 'c' char,so we want to mark all the elements from the 1st pointer till we find the occurence of 'c'
                // while incrementing 1st pointer, we found 'c' at 2 ith, so we marked from 0 to 2 ith as false
                int firstCharIndex = s.charAt(first);
                countArray[firstCharIndex] = false;
                first++;
            }

            // this has 2 use case
            // 1st : Generally we want to mark the char as true, if it's false and increment the 2nd index
            // 2nd : when we had found that a char is already present and we marked the chars as false using 1st pointer, we want to also mark the 2nd occurence of that char as true
            // in above EX: we saw that 'c' occurred 2nd time at 5ith, so we started moving 1st pointer and it found 'c' at 2ith, now we updated 'c' as false bcz of 2 ith
            // but we also want to mark the presence of 'c' at 5ith, so here we mark that as true
            countArray[secondCharIndex] = true;
            second++;

            int currentLength = second - first;
            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;
    }
}
