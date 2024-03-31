package coderarmy.binarysearch.interview;

// Same Problem : CapacityToShipPackagesInDays, PainterAllocation, Split Array Largest Sum
// MIN of all the max values
// Max sum of all the sub array and than the minimum in all the max ans min (max ans of all sub -array)

// contiguous order means take elements side by side, not random

// find the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.
//N = 4
//A[] = {12,34,67,90}
//M = 2
//Output:113
//Explanation:Allocation can be done in
//following ways:
//{12} and {34, 67, 90} Maximum Pages = 191
//{12, 34} and {67, 90} Maximum Pages = 157
//{12, 34, 67} and {90} Maximum Pages =113.
//Therefore, the minimum of these cases is 113,
//which is selected as the output.


// When we are dividing in multiple permutations, we need the get the max no. of pages that is allocated to student but out of all permutation it should be the minimum value
public class BookPagesAllocation_Int {

    public static void main(String[] args) {

//        int array[] = {5, 10, 30, 20, 15};
        int array[] = {12, 34, 67, 90};
        System.out.println("ANS " + findPagesv2(array, array.length, 2));
    }

    // Minimum no. of pages if we need to allocate pages to every student
    public static int findPages(int[] arr, int N, int M) {

//        FINAL TC=> O(N+N * Log N) ==> O(N* logN), bcz when N* logN is calculated the N+ is negligible, so we don't consider it
//        SC=>O(1)


        if (M > N) {// if peoples (M) are more than array elements than how can you divided between all M
            return -1;
        }
        int start = 0; // max no. in array
        int end = 0;// sum of all elements
        for (int i = 0; i < N; i++) {// TC=> O(N)
            if (arr[i] > start) {
                start = arr[i];
            }
            end = end + arr[i];
        }
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int personCount = getPersonCount(arr, N, mid);// TC=> N
            //IMP
            // go left
            if (personCount <= M) {// so if the personCount < M that means everyone(M) didn't received the pages, so we need to more divide and get the mid that will give pages to all M persons
                // Here = is also checked to assign the ans, so if personCount== M, than we want the mid value to be assigned in the ans
                ans = mid;// always assign in left bcz we want the minimum no. of pages
                end = mid - 1;
            } else {//move right : if for each person the minimum pages is provided than we move right. so if mid is person 1 has 10 pages, person 2 has 9 pages, more 12 pages are pending and m=2, so we need to move right
                start = mid + 1;
            }
        }

        return ans;
    }

    private static int getPersonCount(int[] arr, int N, int mid) {
        int page = 0;
        int personCount = 1;// default 1 bcz we are assigning it to 1st person
        for (int i = 0; i < N; i++) {

            page = page + arr[i];
            if (page > mid) {// page > mid, means the current person cannot have more than mid value pages, so if page is > mid than it's time to give pages to next person
                personCount++; // this means pages are given to next element
                page = arr[i]; // this is given to next element, so it's directly assigned
            }
        }
        return personCount;
    }


    // we don't have this condition that we need to allocate to every students. Now we want max pages that can be allocated
    // Below code is not needed, bcz ans will always be the sum of all elements
    public static int findPagesv2(int[] arr, int N, int M) {

//        FINAL TC=> O(N+N * Log N) ==> O(N* logN), bcz when N* logN is calculated the N+ is negligible, so we don't consider it
//        SC=>O(1)


        if (M > N) {// if peoples (M) are more than array elements than how can you divided between all M
            return -1;
        }
        int start = 0; // max no. in array
        int end = 0;// sum of all elements
        for (int i = 0; i < N; i++) {// TC=> O(N)
            if (arr[i] > start) {
                start = arr[i];
            }
            end = end + arr[i];
        }
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int personCount = getPersonCount(arr, N, mid);// TC=> N
            //IMP
            // go right
            if (personCount <= M) {// so if the personCount < M that means everyone(M) didn't received the pages, so we need to more divide and get the mid that will give pages to all M persons
                // Here = is also checked to assign the ans, so if personCount== M, than we want the mid value to be assigned in the ans
                ans = mid;// always assign in right bcz we want the max no. of pages
                start = mid + 1;

            } else {//move left
                end = mid - 1;
            }
        }

        return ans;
    }
}
