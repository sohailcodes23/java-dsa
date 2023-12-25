package practice.two_pointers;

public class StringIsSubSequence {

    public static void main(String[] args) {

        System.out.printf("ANS " + isSubsequence_Brute("acb", "ahbgdc"));
    }

    // leetcode
    public static boolean isSubsequence_Optimal(String s, String t) {
//        TC=>O(N), N=s.length + t.length
//        SC=>O(1)
        int i = 0, j = 0; // i => s pointer, j=> t pointer

        while (i < s.length() && j < t.length()) { // checking both pointer so that it should throw IndexOutOfBound

            if (s.charAt(i) == t.charAt(j)) { // if equal than move both pointers, bcz
                i++; //i will move so that we can check next element
                j++; // j will move bcz we don't want to use the same element
            } else { // if not fount than move the j
                j++; // Since we didn't found we need to move forward we can't check the whole string
            }

        }

        if (i == s.length()) { // if i = s length that means all the elements were found in j.
            // if the elements are not there than j will reach t.length and the while loop will stop and i will not be equal to s.length
            return true;
        }

        return false;
    }


    public static String isSubsequence_Optimalv2(String str1, String str2) {
//        TC=>O(N), N=str1.length + str2.length
//        SC=>O(1)
        int i = 0, j = 0; // i => str1 pointer, j=> str2 pointer

        while (i < str1.length() && j < str2.length()) { // checking both pointer so that it should throw IndexOutOfBound

            if (str1.charAt(i) == str2.charAt(j)) { // if equal than move both pointers, bcz
                i++; //i will move so that we can check next element
                j++; // j will move bcz we don'str2 want to use the same element
            } else { // if not fount than move the j
                j++; // Since we didn'str2 found we need to move forward we can'str2 check the whole string
            }

        }

        if (i == str1.length()) { // if i = str1 length that means all the elements were found in j.
            // if the elements are not there than j will reach str2.length and the while loop will stop and i will not be equal to str1.length
            return "True";
        }

        return "False";
    }


    //own

    public static boolean isSubsequence_Brute(String s, String t) {
//        TC=> O(N x M), n= s.length and m = t.length
//        SC=> O(N)
        StringBuilder newString = new StringBuilder(); // to append based on the matching

        boolean exist = false;
        if (s.trim().isEmpty()) { // edge case
            return true;
        }
        int startIndexForT = 0;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            exist = false;
            for (int j = startIndexForT; j < t.length(); j++) { // j=start index, bcz we want than if something is matched at some index than the next char should be after that not before that. That's why it is updated after the loop

                if (currentChar == t.charAt(j)) {
                    exist = true; // updating bcz if even 1 char is not there in 2nd string than return false
                    startIndexForT = j; // since matched so we need to update the index
                    newString.append(t.charAt(j));
                    break; // edge case and also no need to check further
                }
            }

            if (!exist) { // false that means current char does exist, so no need to check further
                break;
            }
            startIndexForT++; // as discussed needed to check further in 2nd string
        }

        if (s.equals(newString.toString())) { // if the new str is equal than they are correct
            return true;
        }

        return false;
    }
//    public static String isSubsequence(String str1, String str2) {
//
//
//    }
}
