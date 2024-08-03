package coderarmy.string;

//https://www.geeksforgeeks.org/problems/sort-a-string2943/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
public class SortAString {

    public static void main(String[] args) {
//        String s = "asfjxabndzhji";
        String s = "edcab";
        System.out.println("ANS " + sort(s));
    }

    static String sort(String s) {
        // FINAL TC=> O(N)
        //SC=> O(N)
        int[] array = new int[26];
        // TC=O(N)
        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';
            array[index]++;
        }
        // Using StringBuilder for efficient concatenation
        StringBuilder ans = new StringBuilder();
        // O(26)= O(1), constant
        // Building the sorted string: O(n)
        for (int i = 0; i < 26; i++) {
            char current = (char) ('a' + i);
            while (array[i] > 0) {
                ans.append(current);
                array[i]--;
            }
        }

        return ans.toString();
    }
}
