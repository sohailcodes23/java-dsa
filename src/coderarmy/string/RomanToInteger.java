package coderarmy.string;

import java.util.HashMap;

// Simple rule: if ith < (i + 1)th, than sum = -ith + (i+1)th
// else sum= ith + (i+1)th
public class RomanToInteger {

    public static void main(String[] args) {
//        String s = "III"; //3
        String s = "LVIII";//58
        System.out.println("ANS " + romanToInt(s));
    }

    public static int romanToInt(String s) {
        // TC=> O(N)
        // SC=>O(N), we can avoid this by using if else conditions in a method and passing the char in that method to get the value
        int n = s.length();
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int sum = 0;
        for (int i = 0; i <= n - 2; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                sum -= romanMap.get(s.charAt(i));
            } else {
                sum += romanMap.get(s.charAt(i));
            }
        }

        sum += romanMap.get(s.charAt(n - 1));// bcz we were checking ith+(i+1)th, we skipped last char, so adding it at the end

        return sum;
    }
}
