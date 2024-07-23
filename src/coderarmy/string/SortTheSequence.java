package coderarmy.string;

public class SortTheSequence {

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
//        String s = "QcGZ4 TFJStgu3 HvsRImLBfHd8 PaGqsPNo9 mZwxlrYzanuVOUZoyNjt1 fzhdtYIen6 mV7 LKuaOtefsixxo5 pwdEK2";

        System.out.println("ANS " + sortSentence_Better(s));
    }

    public static String sortSentence_Better(String s) {

        //FINAL TC=>O(N) + O(N) = O(2N) ==> O(N)

        // FINAL SC = O(N)
        //Combining Space Complexities
        //StringBuilder: O(N)
        //Temporary Array: O(1)
        //Temporary Strings: O(N)
        StringBuilder stringBuilder = new StringBuilder();
        String[] temp = new String[10];
        String tempString = "";
        int position = 0;
        int count = 1;

        //TC=>O(N)
        for (int i = 0; i < s.length(); i++) {

            if (!String.valueOf(s.charAt(i)).equals(" ")) {

                tempString += s.charAt(i);
            } else {

                position = Integer.parseInt(tempString.substring(tempString.length() - 1)); // get the index position
                tempString = tempString.substring(0, tempString.length() - 1); // trim to get only the string

                temp[position] = tempString;
                count++;
                tempString = "";
            }

        }

        //Processing the Last Element: TC => O(1)
        /// For the last element of the temp array
        position = Integer.parseInt(tempString.substring(tempString.length() - 1));
        tempString = tempString.substring(0, tempString.length() - 1);
        temp[position] = tempString;

        //TC=>O(N)
        // Create the new String
        for (int i = 1; i <= count; i++) {
            if (temp[i] != null) {
                stringBuilder.append(temp[i]);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
