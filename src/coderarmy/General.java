package coderarmy;

public class General {

    public static void main(String[] args) {

        System.out.println(convertSmallToBigChar('X'));
    }

    static char convertSmallToBigChar(char name) {

//        char result =( name - 'a') + 'A';
        if (name >= 'a' && name <= 'z') {
            return (char) (name - 32); // to convert to Capital
        }
        return name;
    }

}
