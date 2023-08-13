package linearSeach;

public class StringLinearSearch {

    public static void main(String[] args) {
        String source = "sohail";
        // note only single quotes is used for the char
        char target = 's';
        int indexAns = linearSearch2(source, target);
        System.out.println(indexAns);
    }

    // get char index, if true
    static int linearSearch(String source, char target) {

        for (int index = 0; index < source.length(); index++) {
            char element = source.charAt(index);
// Note char is case sensitive
            if (element == target) {
                return index;
            }
        }


        return Integer.MAX_VALUE;
    }


    // if true, return 1, else 0
    static int linearSearch2(String source, char target) {

        // used toCharArray to convert the source to charArray;
        for (char a : source.toCharArray()) {
            // Note char is case sensitive
            if (a == target) {
                return 1;
            }
        }


        return 0;
    }
}
