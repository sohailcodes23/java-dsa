package coderarmy.string;

//https://www.youtube.com/watch?v=iw9CK0ssgDU&list=PLQEaRBV9gAFu4ovJ41PywklqI7IyXwr01&index=39
public class SortTheVowels {

    public static void main(String[] args) {
//Input: s = "lEetcOde"
//Output: "lEOtcede"

//        String s = "lEetcOde";
//        String s = "lYmpH";
        String s = "LQRamBOHfq";

        System.out.println("ANS " + sortVowels_Optimal(s));
    }


    // Handle multiple occurrence of the char
    public static String sortVowels_Optimal(String s) {

        //FINAL TC=>O(N+N) == O(2N) ==> O(N)
        //FINAL SC=>O(N+N) == O(2N) ==> O(N)

        int lowerVowelsTemp[] = new int[26];// keep the count of the lower char
        int upperVowelsTemp[] = new int[26];// keep the count of the upper char
        StringBuilder stringBuilder = new StringBuilder();
        String sortedVowels = "";
        boolean vowelExist = false;
        //TC==>O(N)
        //SC=>O(N): stringBuilder
        // To get the count of all the vowels and create a new string with marking the vowels
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelExist = true;
                if (s.charAt(i) >= 'a') {//lower if char is >=97
                    int index = s.charAt(i) - 'a';
                    lowerVowelsTemp[index]++;
                } else { // upper if char <=97
                    int index = s.charAt(i) - 'A';
                    upperVowelsTemp[index]++;
                }
                stringBuilder.append("#"); // marking the vowel as #, so we doesn't have to again check if there is a vowel
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println("GG " + stringBuilder);
        if (!vowelExist) {// if there are no vowels we don't have to go forward, EX:lYmpH
            return s;
        }

        //TC=O(26 + 26) ==> O(1), bcz it doesn't depend on n so it's constant
        //Sorting the vowels and saving in sortedVowels so that upper are before lower vowels
        // upper
        for (int i = 0; i < upperVowelsTemp.length; i++) {
            while (upperVowelsTemp[i] != 0) {
                char alpha = (char) ('A' + i);
                sortedVowels += alpha;
                upperVowelsTemp[i]--;
            }
        }

        // lower
        for (int i = 0; i < lowerVowelsTemp.length; i++) {
            while (lowerVowelsTemp[i] != 0) {
                char alpha = (char) ('a' + i);
                sortedVowels += alpha;
                lowerVowelsTemp[i]--;
            }
        }

        System.out.println("GG " + sortedVowels);
        StringBuilder finalAns = new StringBuilder();
        int sortedVowelsIndex = 0;
        //TC==>O(N)
        //SC=>O(N)
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '#') {
                finalAns.append(sortedVowels.charAt(sortedVowelsIndex));
                sortedVowelsIndex++;
            } else {
                finalAns.append(stringBuilder.charAt(i));
            }
        }

        return finalAns.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' ||
                c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // Won't work when characters repeat itself
    public static String sortVowels_Brute(String s) {
        // FINAL TC=> O(N)+O(N)=O(2N) ==> O(N)
        // SC=> O(N)

        // BELOW SC are constant
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        char lowerVowelsTemp[] = new char[26];
        char upperVowelsTemp[] = new char[26];
        int upperIndex = 0;
        int lowerIndex = 0;

        //TC=> O(10×N)=O(N)
        for (int i = 0; i < vowels.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (vowels[i] == s.charAt(j)) {
                    if (s.charAt(j) >= 'a') {//lower
                        lowerVowelsTemp[lowerIndex] = s.charAt(j);
                        lowerIndex++;
                    } else {//upper
                        upperVowelsTemp[upperIndex] = s.charAt(j);
                        upperIndex++;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder(); // SC=> O(N)
        int upperIteratorIndex = 0;
        int lowerIteratorIndex = 0;
        // TC+> O(N×10)=O(10N)=O(N)
        for (int j = 0; j < s.length(); j++) {
            boolean vowel = false;
            for (int i = 0; i < vowels.length; i++) {
                if (vowels[i] == s.charAt(j)) {
                    if (upperIteratorIndex != upperIndex) {
                        stringBuilder.append(upperVowelsTemp[upperIteratorIndex]);
                        upperIteratorIndex++;
                    } else {

                        stringBuilder.append(lowerVowelsTemp[lowerIteratorIndex]);
                        lowerIteratorIndex++;
                    }
                    vowel = true;
                }
            }
            if (!vowel) {
                stringBuilder.append(s.charAt(j));
            }
        }

        return stringBuilder.toString();
    }
}
