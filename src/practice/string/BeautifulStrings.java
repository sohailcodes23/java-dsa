package practice.string;

public class BeautifulStrings {

    public static void main(String[] args) {

//        String str = "0000";//2
//        String str = "01011";// 1
//        String str = "1010";//0
        String str = "1001";
//        System.out.println("ANS " + makeBeautiful(str));
        System.out.println("ANS " + makeBeautiful_Optimal1(str));
    }

    public static int makeBeautiful(String str) {
//0000
        int n = str.length();
        int updatedCount = 1;
        char previous = 0;
        for (int i = 0; i < n - 1; i++) {
            System.out.println(str.charAt(i) + " EE " + previous);
            if (str.charAt(i) == '0' && str.charAt(i + 1) != '1') {

                updatedCount++;

            } else if (str.charAt(i) == '1' && str.charAt(i + 1) != '0') {
                updatedCount++;
            }
            if (previous == str.charAt(i)) {
                System.out.println("I 3");
                updatedCount = updatedCount + 2;
            }
            previous = str.charAt(i);
        }
        System.out.println("U " + updatedCount);
        updatedCount = updatedCount / 2;
        if (updatedCount == str.length()) {
            updatedCount = updatedCount / 2;
        }
        return updatedCount;
    }

    public static int makeBeautiful_Optimal1(String str) {
//        According to us it should be '01' or '10' and it should continue like that
//        by this logic for first: 0 should be at even and 1 should be at odd
//        by this logic for seconds: 1 should be at even and 0 should be at odd

        int n = str.length();
        int count01 = 0; // to count '01' pattern
        int count10 = 0; // to count '10' pattern
        for (int i = 0; i < n; i++) {
            char desiredChar1;
            char desiredChar2;
            if (i % 2 == 0) { // to check '01' pattern
                desiredChar1 = '0';
            } else {
                desiredChar1 = '1';
            }

            if (i % 2 == 0) { // to check '10' pattern
                desiredChar2 = '1';
            } else {
                desiredChar2 = '0';
            }

            if (str.charAt(i) != desiredChar1) {  // checking pattern '01'
                count01++;
            }


            if (str.charAt(i) != desiredChar2) { // checking pattern '10'
                count10++;
            }
        }

        return Math.min(count01, count10); // which ever is small is the ans

    }


    public static int makeBeautiful_S(String str) {
        char[] ch = str.toCharArray();
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < ch.length; i++) {
            System.out.println("I " + i);
            if (i % 2 == 0) {
                if (ch[i] == '1') count++;
            } else {
                if (ch[i] == '0') count++;
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if (i % 2 == 0) {
                if (ch[i] == '0') count1++;
            } else {
                if (ch[i] == '1') count1++;
            }
        }
        return Math.min(count, count1);

    }


    public static int makeBeautifulv1(String str) {
//0000
        int n = str.length();
        int updatedCount = 1;
        for (int i = 0; i < n - 1; i++) {
            System.out.println(str.charAt(i) + " EE ");
            if (str.charAt(i) == '0') {
                System.out.println("IN 1");
                if (str.charAt(i + 1) == '0') {
                    System.out.println("IN 2");
                    updatedCount++;
                }

            } else {
                if (str.charAt(i + 1) == '1') {
                    updatedCount++;
                }
            }
        }
        System.out.println("U " + updatedCount);
        return updatedCount / 2;
    }
}
