package learnyard.array;

public class LongestRepetitions {

    public static void main(String[] args) {
        System.out.println("JJ "+repetitions());
    }

    public static int repetitions() {
//        String s = "ATTCGGGA";
        String s = "ASHJHHHJGHGTTTTTTTTGHGGGGYYUUUIIIHHJHHGGDTDR"; //8

        int count = 0;
        int i = 0;
        int j = 1;

        while (i < s.length() && j < s.length()) {

            if (s.charAt(i) != s.charAt(j)) {
                count = Math.max(count, j - i);
                j++;
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}
