package coderarmy.string;

public class CheckIdSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
// TC=O(N)
        boolean[] alpha = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            int index = sentence.charAt(i) - 'a';
            alpha[index] = true;
        }
// Bcz we have used a constant space like 26 the TC will be O(26) ==> O(1), constant
// Even if there are 500 char in sentence this alpha array will always be 26 so it's constant
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == false) {
                return false;
            }
        }

        return true;

    }

}
