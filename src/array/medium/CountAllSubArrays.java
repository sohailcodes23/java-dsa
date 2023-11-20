package array.medium;

public class CountAllSubArrays {

    public static void main(String[] args) {
//        int array[] = {3, 1, 2, 4};
        int array[] = {1, 2, 3};

        System.out.println("ANS " + findAllSubarraysWithGivenSum(array, 3));

    }

//    OWN
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            int sum = 0;
            for (int j = i; j < arr.length; j++) {

                sum = arr[j] + sum;
                if (sum == s) {
                    count++;
                }
            }
        }
        return count;

    }


}
