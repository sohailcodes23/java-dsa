package coderarmy.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseSpecificSortingOfStrings {

    public static void main(String[] args) {

//        String s = "srbDKi";//birDKs
        String s = "defRTSersUXI";//deeIRSfrsTUX
        System.out.println("ANS " + caseSort_Brute(s));
        System.out.println("ANS " + caseSort_Optimized(s));
    }

    public static String caseSort_Optimized(String str) {
        // FINAL TC=> O(N) + O(N logN) ==> O(N logN), here the dominant is sorting that's why we can ignore O(N)
        // FINAL SC=> O(N + N + N) ==> O(3N) ==> O(N)

        List<Character> lowers = new ArrayList<>();// SC=> O(N)
        List<Character> uppers = new ArrayList<>();// SC=> O(N)
        int n = str.length();
        // TC=> O(N)
        // save all the lower and upper cases in diff arrays
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowers.add(ch);
            } else {
                uppers.add(ch);
            }
        }

        // Sort both the arrays: bcz of this we can take iterate through the array
        // Sorting also helps with handling duplicate chars
        //EX lower: {d e a f e r}  , after sorting lower: {a d e e f r}
        Collections.sort(lowers); // TC=> O(l logl), l is no. of lower chars
        Collections.sort(uppers); // TC=> O(u logu), u is no. of upper chars
        // Worst case l + u, so TC=> O(n logn)

        StringBuilder stringBuilder = new StringBuilder();// SC=> O(N)
        int lowerIndex = 0; // to traverse through the array
        int upperIndex = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                stringBuilder.append(lowers.get(lowerIndex));
                lowerIndex++;
            } else {
                stringBuilder.append(uppers.get(upperIndex));
                upperIndex++;
            }
        }


        return stringBuilder.toString();
    }

    public static String caseSort_Brute(String str) {
//      FINAL TC==> O(N)
//      SC TC==> O(N)
        int lower[] = new int[26]; // SC => O(1)
        int upper[] = new int[26];// SC => O(1)
        int n = str.length();
//        TC==> O(N)
        // to sort and save the lower and upper characters in a diff array
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= 97) { // lower
                int index = ch - 'a';
                lower[index]++;
            } else {
                int index = ch - 'A';
                upper[index]++;
            }
        }
        //        SC==> O(N)
        StringBuilder stringBuilder = new StringBuilder();// to store the new ans
        //        TC==> O(N) + O(26) + O(26) ==> O(N), the while loop is negligible
        for (int i = 0; i < n; i++) {// we will check through all the value and evaluate based on the lower and upper case
            char ch = str.charAt(i);
            boolean found = false;
            if (ch >= 97) { // if the char is lower
                for (int j = 0; j < 26; j++) { // looping through all the 26 elements
                    int prev = lower[j]; // need this previous value to compare for the chars which are multiple in the string
                    //EX: defRTSersUXI, here we have 2 'e''e' in the string and we only want to update the current char with a single char, if we don't add prev == lower[j], it will add the chars in loop
                    while (lower[j] != 0 && prev == lower[j]) {
                        char current = (char) ('a' + j); // to get the char
                        stringBuilder.append(current);
                        lower[j]--;
                        found = true;// to break the loop if a char is found
                    }
                    if (found) {
                        break;
                    }
                }
            } else {
                for (int j = 0; j < 26; j++) {
                    int prev = upper[j];
                    while (upper[j] != 0 && prev == upper[j]) {
                        char current = (char) ('A' + j);
                        stringBuilder.append(current);
                        upper[j]--;
                        found = true;
                    }
                    if (found) {
                        break;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
