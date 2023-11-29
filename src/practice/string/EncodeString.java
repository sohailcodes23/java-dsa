package practice.string;

public class EncodeString {

    public static void main(String[] args) {

//        String input = "aabbc"; //a2b2c1
        String input = "abbdcaas"; //a1b2d1c1a2s1
        System.out.println("ANS " + encode(input));
    }

    public static String encode(String message) {

        StringBuilder output = new StringBuilder();
        int n = message.length();
        int counter = 1;
        for (int i = 0; i < n - 1; i++) {

            if (message.charAt(i) == message.charAt(i + 1)) {
                counter++;
            } else {

                output.append(message.charAt(i)).append(counter);

                counter = 1;// reset the counter
            }
        }

        output.append(message.charAt(n - 1)).append(counter);

        return output.toString();
    }


    public static String encode_S(String message) {
        StringBuilder res = new StringBuilder();

        int counter = 1;
        for (int i = 0; i < message.length() - 1; i++) {
            if (message.charAt(i) == message.charAt(i + 1)) {
                counter++;
            } else {
                res.append(message.charAt(i));

                res.append(counter);

                counter = 1;
            }
        }

        res.append(message.charAt(message.length() - 1));

        res.append(counter);

        return res.toString();
    }

    public static String encode_Brute(String message) {
//        TC=> O(N^2)
//        SC=> O(N)
        char[] inputValues = message.toCharArray();
        int n = inputValues.length;
        StringBuilder output = new StringBuilder();
        char previousElement = 0;

        for (int i = 0; i < n; i++) {

            char current = inputValues[i];
            int currentCounter = 1;
            for (int j = i + 1; j < n; j++) {

                if (current != previousElement &&
                        current == inputValues[j]) {
                    currentCounter++;
                } else {
                    break;
                }
            }
            if (current != previousElement) {
                output.append(current).append(currentCounter);
            }
            previousElement = current;
        }

        return output.toString();
    }
}
