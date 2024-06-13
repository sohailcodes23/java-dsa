package coderarmy.string;

public class CheckStringIsRotated {

    public static void main(String[] args) {


        int array[] = {1, 2, 3, 4, 5, 6, 7};
//        int array[] = {1, 3, 4, 5, 6, 7, 7};
//gvxc
//cgxv

//        daxjheq
//                eqdaxjh
        System.out.println("ANS " + isRotated("daxjheq", "eqdaxjh"));
//        System.out.println("ANS " + isRotated("gvxc", "cgxv"));
//        rotateArrayClockwise(array);
//        rotateArrayClockwise(array);
    }

    //
    public static boolean isRotated(String str1, String str2) {

        if (str1.isEmpty() || str2.isEmpty()) {
            return false;
        }

        String value = str1;
        value = rotateArrayClockwise(value);
        value = rotateArrayClockwise(value);
//        System.out.println("V " + value);
        if (value.equals(str2)) {
            return true;
        }


        value = str1;
        value = rotateArrayAntiClockwise(value);
        value = rotateArrayAntiClockwise(value);
//        System.out.println("V " + value);
        if (value.equals(str2)) {
            return true;
        }


        return false;
    }

    static String rotateArrayAntiClockwise(String value) {
        char[] array = value.toCharArray();
        int n = array.length;
        char temp = array[0];

        for (int i = 0; i <= n - 2; i++) {
            array[i] = array[i + 1];
        }

        array[n - 1] = temp;

        //System.out.println("AA " + Arrays.toString(array));


        return new String(array);
    }

    static String rotateArrayClockwise(String value) {
        char[] array = value.toCharArray();
        int n = array.length;
        char temp = array[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }

        array[0] = temp;

        //System.out.println("AA " + Arrays.toString(array));

        return new String(array);
    }
}
