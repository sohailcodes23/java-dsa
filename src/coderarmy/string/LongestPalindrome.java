package coderarmy.string;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println("ANS " + longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        // TC= O(N)
        // SC =O(1)
        int[] lower = new int[26];
        int[] upper = new int[26];

        // Count of all the alpha
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 'a') { // it is a lower alpha
                int index = s.charAt(i) - 'a';// index of current alpha
                lower[index]++;
            } else {
                int index = s.charAt(i) - 'A';// index of current alpha
                upper[index]++;
            }
        }

        int count = 0;
        int odd = 0;
        // bcz only 26 aplha
        for (int i = 0; i < 26; i++) {
            //LOWER
            if (lower[i] % 2 == 0) {// if the count is even
                count += lower[i];
            } else {
                count += lower[i] - 1;//lower[i] - 1 , bcz we can only add even alpha on both the side, EX if 'AAAb' than we can do AbA, only 2 is required from the 'A' count
                odd = 1;// bcz in the middle only one odd alpha can be added
            }


            //Upper
            if (upper[i] % 2 == 0) {// if the count is even
                count += upper[i];
            } else {

                count += upper[i] - 1;//lower[i] - 1 , bcz we can only add even alpha on both the side, EX if 'AAAb' than we can do AbA, only 2 is required from the 'A' count
                odd = 1;// bcz in the middle only one odd alpha can be added
            }
        }


        return count + odd;
    }
}
