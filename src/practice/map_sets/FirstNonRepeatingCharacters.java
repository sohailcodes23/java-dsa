package practice.map_sets;

import java.util.HashMap;

public class FirstNonRepeatingCharacters {

    public static void main(String[] args) {


//        String s = "AabBcC";
//        String s = "ybgofbtwhrylqppidnejjkcyiyosqcotfjugqkgvvbblyagmkgakawmthhrdmcfqqospslebhhnvwdym";
        String s = "aDcadhc";

        System.out.println("ANS " + firstNonRepeatingCharacter(s));
    }


    public static char firstNonRepeatingCharacter(String str) {

//        TC=> O(2N) -> O(N)
//        SC=> O(N)

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (hashMap.get(c) == 1) {
                return c;
            }
        }

        return str.charAt(0);
    }
}
