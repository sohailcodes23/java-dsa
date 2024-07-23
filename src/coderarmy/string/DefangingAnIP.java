package coderarmy.string;

//https://leetcode.com/problems/defanging-an-ip-address/description/
public class DefangingAnIP {

    public static void main(String[] args) {
//"1.1.1.1": "1[.]1[.]1[.]1"
        System.out.println("ANS " + defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String newVal = new String();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '.') {
                newVal += "[.]";
                stringBuilder.append("[.]");
            } else {
                newVal += input.charAt(i);
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
