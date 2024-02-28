package coderarmy.binarysearch.interview;


// Same as BookPagesAllocation. same code as well
public class PainterAllocation {
    public static void main(String[] args) {

        int array[] = {5, 10, 30, 20, 15};
//        int array[] = {12, 34, 67, 90};
        System.out.println("ANS " + minTime(array, array.length, 3));
    }

    static long minTime(int[] arr, int N, int M) {
        long start = 0; // max no. in array
        long end = 0;// sum of all elements
        for (int i = 0; i < N; i++) {
            if (arr[i] > start) {
                start = arr[i];
            }
            end = end + arr[i];
        }

        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long personCount = getPersonCount(arr, N, mid);// TC=> N
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

    private static long getPersonCount(int[] arr, int N, long mid) {
        long page = 0;
        long personCount = 1;// default 1 bcz we are assiging it to 1st person
        for (int i = 0; i < N; i++) {

            page = page + arr[i];
            if (page > mid) {// page > mid, means the current person cannot have more than mid value pages, so if page is > mid than it's time to give pages to next person
                personCount++; // this means pages are given to next element
                page = arr[i]; // this is given to next element, so it's directly assigned
            }
        }
        return personCount;
    }
}
