package coderarmy.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("ANS " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            String first = strs[0];
            char ch = first.charAt(i); // get the string from the first string to check if it exist in other strings
            boolean match = true;
            for (int j = 1; j < strs.length; j++) {// j==1, bcz we want to check from the next string

                if (strs[j].length() < i //
                        || ch != strs[j].charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                break;
            } else {
                prefix.append(ch);
            }
        }

        return prefix.toString();
    }
}
