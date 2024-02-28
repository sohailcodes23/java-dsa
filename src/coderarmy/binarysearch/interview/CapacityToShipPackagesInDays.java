package coderarmy.binarysearch.interview;


// Same as BookPagesAllocation. same code as well
public class CapacityToShipPackagesInDays {

    public static void main(String[] args) {

        int[] array = {3, 6, 7, 11};
        System.out.println("ANS "+shipWithinDays(array,8));
    }

    public static int shipWithinDays(int[] weights, int days) {
//        FINAL TC=> O(N+N * Log N) ==> O(N* logN), bcz when N* logN is calculated the N+ is negligible, so we don't consider it
//        SC=>O(1)

        int N = weights.length;

        int start = 0; // max no. in array
        int end = 0;// sum of all elements
        for (int i = 0; i < N; i++) {// TC=> O(N)
            if (weights[i] > start) {
                start = weights[i];
            }
            end = end + weights[i];
        }

        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int dayCount = getDaysCount(weights, N, mid);// TC=> N
            //IMP
            // go left
            if (dayCount <= days) {// so if the dayCount < days that means everyone(days) didn't received the packages, so we need to more divide and get the mid that will give packages to all days days
                // Here = is also checked to assign the ans, so if dayCount== days, than we want the mid value to be assigned in the ans
                ans = mid;// always assign in left bcz we want the minimum no. of packages
                end = mid - 1;
            } else {//move right : if for each day the minimum packages is provided than we move right. so if mid is day 1 has 10 packages, day 2 has 9 packages, more 12 packages are pending and m=2, so we need to move right
                start = mid + 1;
            }
        }

        return ans;
    }

    private static int getDaysCount(int[] arr, int N, int mid) {
        int packages = 0;
        int dayCount = 1;// default 1 bcz we are assigning it to 1st day
        for (int i = 0; i < N; i++) {

            packages = packages + arr[i];
            if (packages > mid) {// packages > mid, means the current day cannot have more than mid value packages, so if packages is > mid than it's time to give packages to next day
                dayCount++; // this means packages are given to next element
                packages = arr[i]; // this is given to next element, so it's directly assigned
            }
        }
        return dayCount;
    }

}
