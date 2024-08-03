package coderarmy.slidingwindow;

//SmallestDistinctWindow: https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1?page=1&difficulty%5B%5D=1&category%5B%5D=Strings&sortBy=submissions
//findSubStringWindowContaining012: https://www.geeksforgeeks.org/problems/smallest-window-containing-0-1-and-2--170637/1
public class SmallestDistinctWindow {

    public static void main(String[] args) {
//        String s = "AABBBCBBAC";// 3: BAC


        //Smallest window containing 0, 1 and 2
        String s = "10212";//3
//        String s = "12121";// -1, bcz there is no 0

        System.out.println("ANS " + findSubStringWindowContaining012(s));
    }


    public static int findSubStringWindowContaining012(String s) {
//        TC=> O(N)
//        SC=> O(1)
        int n = s.length();
        int countArray[] = new int[256];

        int first = 0, second = 0, len = n;
        int diff = 0;
        // calculate all the unique chars in string
        while (first < n) {
            // at first index value is 'A'
            // if s.charAt(first) == A, than increase it's value, now next time we know this is already counted in diff
            if (countArray[s.charAt(first)] == 0) {
                diff++;// increase the count on unique char
            }
            countArray[s.charAt(first)]++;// increase the count to know this char is included in the diff
            first++;// will go till end of the string

        }

        if (diff < 3) {
            return -1;
        }

        // reset the countArray for further use
        for (int i = 0; i < 256; i++) {
            countArray[i] = 0;
        }

        first = 0;// reset the first to create a sliding window


        while (second < n) {// second<n bcz we are creating a window
            // Increase second till we have a diff
            // EX if the diff = 3, A B C that means we still have unique chars and those are not found in the string yet
            while (diff > 0
                    && second < n) {// since second is increasing we need to check this
                //we need to decrease diff if we see a char for the 1st time
                if (countArray[s.charAt(second)] == 0) {
                    diff--;
                }
                countArray[s.charAt(second)]++;// increase the count for the char, so when second is moving if we find 3 'A', than we need to increase the count
                second++;// while adding this it might throw index error, so we need to handle this in while(diff>0)

            }

            len = Math.min(len, second - first);// we need the smallest window

            // so when diff==0, we need to decrease the window using first
            while (diff == 0) {
                len = Math.min(len, second - first);// we again added this line bcz as soon as window is decreased we need to check if we got a smaller window than before
                countArray[s.charAt(first)]--;// decreasing the window

                if (countArray[s.charAt(first)] == 0) {// this means now we don't have all the unique chars in the window, we need to increase the window so we will add diff
                    diff++;
                }

                first++;// to decrease the window
            }
        }

        return len;
    }

    public static int findSubString(String s) {
//        TC=> O(N)
//        SC=> O(1)
        int n = s.length();
        int countArray[] = new int[256];

        int first = 0, second = 0, len = n;
        int diff = 0;
        // calculate all the unique chars in string
        while (first < n) {
            // at first index value is 'A'
            // if s.charAt(first) == A, than increase it's value, now next time we know this is already counted in diff
            if (countArray[s.charAt(first)] == 0) {
                diff++;// increase the count on unique char
            }
            countArray[s.charAt(first)]++;// increase the count to know this char is included in the diff
            first++;// will go till end of the string

        }

        // reset the countArray for further use
        for (int i = 0; i < 256; i++) {
            countArray[i] = 0;
        }

        first = 0;// reset the first to create a sliding window


        while (second < n) {// second<n bcz we are creating a window
            // Increase second till we have a diff
            // EX if the diff = 3, A B C that means we still have unique chars and those are not found in the string yet
            while (diff > 0
                    && second < n) {// since second is increasing we need to check this
                //we need to decrease diff if we see a char for the 1st time
                if (countArray[s.charAt(second)] == 0) {
                    diff--;
                }
                countArray[s.charAt(second)]++;// increase the count for the char, so when second is moving if we find 3 'A', than we need to increase the count
                second++;// while adding this it might throw index error, so we need to handle this in while(diff>0)

            }

            len = Math.min(len, second - first);// we need the smallest window

            // so when diff==0, we need to decrease the window using first
            while (diff == 0) {
                len = Math.min(len, second - first);// we again added this line bcz as soon as window is decreased we need to check if we got a smaller window than before
                countArray[s.charAt(first)]--;// decreasing the window

                if (countArray[s.charAt(first)] == 0) {// this means now we don't have all the unique chars in the window, we need to increase the window so we will add diff
                    diff++;
                }

                first++;// to decrease the window
            }
        }

        return len;
    }

}
