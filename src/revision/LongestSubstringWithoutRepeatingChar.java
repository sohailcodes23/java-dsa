package revision;

// Using: Sliding Window Protocol
public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
//        String s = "abcdecbeadf";//6
        String s = "pwwkew";//3

        System.out.println("ANS " + lengthOfLongestSubstringv2(s));

    }

    public static int lengthOfLongestSubstringv2(String s) {
        int n = s.length();

        boolean[] charArray = new boolean[256];
        int left = 0, right = 0, maxLen = 0;
        while (right < n) {

            while (charArray[s.charAt(right)] == true) {
                charArray[s.charAt(left)] = false;
                left++;
            }

            charArray[s.charAt(right)] = true;
            right++;
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
