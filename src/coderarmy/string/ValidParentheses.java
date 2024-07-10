package coderarmy.string;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
    }

    public static boolean isValid(String s) {
//        TC=> O(N)
//        SC=> O(N)
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char it = s.charAt(i);
            if (it == '(' || it == '{' || it == '[') {// adding the start bracket chars
                characters.add(it);
            } else {
                if (characters.isEmpty()) {// if it came here, than it might be ) (, closing is before the opening, so it is invalid, it should be always open than close, ( ) OR ( { ) }, something like this
                    return false;
                }
                char popLast = characters.pop();
                if (popLast == '(' && it == ')' || popLast == '{' && it == '}' || popLast == '[' && it == ']') {
                    continue; // that means the bracket is valid
                } else return false;
            }
        }

        return characters.isEmpty();// stack should be empty, than it has all the valid parentheses
    }
}
