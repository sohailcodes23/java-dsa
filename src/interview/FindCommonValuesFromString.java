package interview;

import java.util.HashMap;

public class FindCommonValuesFromString {

    public static void main(String[] args) {
        String str1 = "ABCDCD"; // ABCD
        String str2 = "CDEFD";

        // Expected O/P=> CDD
        System.out.println("ANS " + findCommonValue(str1, str2));
    }

    public static String findCommonValue(String str1, String str2) {


        // Create a HashMap to store characters and their counts from the first string
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // StringBuilder to store common characters
        StringBuilder commonChars = new StringBuilder();

        // Check characters of the second string against the HashMap
        for (char c : str2.toCharArray()) {
            if (charCountMap.containsKey(c) && charCountMap.get(c) > 0) {
                commonChars.append(c);
                charCountMap.put(c, charCountMap.get(c) - 1);
            }
        }

        return commonChars.toString();

    }

}
