package practice.string;

public class MinimumParentheses {

    public static void main(String[] args) {
//        String input = "()))(("; // 0
        String input = ")((()"; // 0

        System.out.println("ANS " + minAddToMakeValid(input));
    }

    public static int minAddToMakeValid(String s) {

        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {// check if any bracket is opened

                open++;
            } else {
                // any time there is close parenthesis it will be here

                if (open == 0) { // till now any bracket hasn't not been opened like ')'
                    close++; // just to keep the close brcket data
                } else { // this basically means that the current bracket is a close one, but it is after the open one like '()'
                    open--;
                }
            }

        }
        return (open + close);

    }
}
