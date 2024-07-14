package coderarmy.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"ab", "a"};
        System.out.println("ANS " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        // TC=O(M * N) , M is length of the string and N is the size of the array
        // SC=> O(M), M bcz we said M is the length of the string
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            String first = strs[0];
            char ch = first.charAt(i); // get the string from the first string to check if it exist in other strings
            boolean match = true;
            for (int j = 1; j < strs.length; j++) {// j==1, bcz we want to check from the next string

                if (strs[j].length() <= i // bcz if jth string is not <= i, than it will throw indexoutofbound
                        || ch != strs[j].charAt(i)) { // checking jth string at the i position
                    match = false;
                    break;// break bcz no need to further check the string
                }
            }
            if (!match) {
                break;// break bcz no need to further check the string
            } else {
                prefix.append(ch);// append if matched
            }
        }

        return prefix.toString();
    }
}
