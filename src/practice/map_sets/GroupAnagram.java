package practice.map_sets;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {

        ArrayList<String> strs = new ArrayList<>();
        strs.addAll(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));

//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println("ANS " + groupAnagrams(strs));
        System.out.println("ANS " + getGroupedAnagrams(strs,strs.size()));
    }

    // optimal leetcode
    public static List<List<String>> groupAnagrams(String[] strs) {

//        TC=> O(M x N), m is the average number of characters and n is the length of the array
//        SC => O(M x N),  m is the average number of characters and n is the length of the array
        List<List<String>> result = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> finalAnagramMap = new HashMap<>();


        for (String s : strs) {
            HashMap<Character, Integer> characterFrequency = new HashMap<>(); // to save the character frequency, like if eatt, than e1 a1 t2
            for (int i = 0; i < s.length(); i++) {
                characterFrequency.put(s.charAt(i), characterFrequency.getOrDefault(s.charAt(i), 0) + 1);
            }

            if (finalAnagramMap.containsKey(characterFrequency)) { // check in the hashmap if there is any other with the same frequency
                // EX=> atte, this will have same frequency like a1 t2 e1, so if that exist than hashmap that that anagram
                List<String> strings1 = finalAnagramMap.get(characterFrequency);
                List<String> newList = new ArrayList<>(strings1); // adding the already existing list
                newList.add(s); // adding current string
                finalAnagramMap.put(characterFrequency, newList); //adding in the list
            } else {
                finalAnagramMap.put(characterFrequency, Collections.singletonList(s)); // for adding first time if that character doesn't exist
            }
        }

//        for (Map.Entry<HashMap<Character, Integer>, List<String>> entry : finalAnagramMap.entrySet()) { // this loop is just to return the ans in required datatype
//
//            result.add(entry.getValue());
//        }

        for (List<String> strings: finalAnagramMap.values()) { // this loop is just to return the ans in required datatype

            result.add(strings);
        }

        return result;
    }

    //codestudio

    public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {

//        TC=> O(M x N), m is the average number of characters and n is the length of the array
//        SC => O(M x N),  m is the average number of characters and n is the length of the array
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> finalAnagramMap = new HashMap<>();


        for (String s : inputStr) {
            HashMap<Character, Integer> characterFrequency = new HashMap<>(); // to save the character frequency, like if eatt, than e1 a1 t2
            for (int i = 0; i < s.length(); i++) {
                characterFrequency.put(s.charAt(i), characterFrequency.getOrDefault(s.charAt(i), 0) + 1);
            }

            if (finalAnagramMap.containsKey(characterFrequency)) { // check in the hashmap if there is any other with the same frequency
                // EX=> atte, this will have same frequency like a1 t2 e1, so if that exist than hashmap that that anagram
                ArrayList<String> strings1 = finalAnagramMap.get(characterFrequency);
                ArrayList<String> newList = new ArrayList<>(strings1); // adding the already existing list
                newList.add(s); // adding current string
                finalAnagramMap.put(characterFrequency, newList); //adding in the list
            } else {
                ArrayList<String> strings= new ArrayList<>();
                strings.add(s);
                finalAnagramMap.put(characterFrequency, strings); // for adding first time if that character doesn't exist
            }
        }


        for (ArrayList<String> strings: finalAnagramMap.values()) { // this loop is just to return the ans in required datatype

            result.add(strings);
        }

        return result;
    }
}
