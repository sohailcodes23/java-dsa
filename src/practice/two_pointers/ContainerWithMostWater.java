package practice.two_pointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int height[] = {4, 3, 2, 1, 4}; //16
//        int height[] = {1, 2, 1}; //2
        int height[] = {12, 4, 6, 8, 1}; //24

        System.out.printf("ANS " + maxArea_optimal(height));
    }

    public static int maxArea_optimal(int[] height) {
// TC=> O(N)

        int n = height.length;
        int maxArea = 0;
        int left = 0, right = n - 1;

        while (left < right) {

            int width = right - left;// width between 2 pointers right to left
            int minHeight = Math.min(height[left], height[right]);// taking minimum height bcz it will spill to the minimum side of the container
            int area = width * minHeight; // area of a rectangle formula
            maxArea = Math.max(area, maxArea); // taking max so we can know the max container size

            if (height[right] > height[left]) { // checking the value so that we can move forward the pointers
                left++;
            } else {
                right--;
            }
        }


        return maxArea;
    }

    public static int maxArea_brute(int[] height) {
//        TC=> O(N^2)
        int n = height.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) { // left pointer

            for (int j = i + 1; j < n; j++) { // right pointer, i+1, bcz right pointer will always be on the right side of the left

                int width = j - i;// width between 2 pointers right to left
                int minHeight = Math.min(height[i], height[j]);// taking minimum height bcz it will spill to the minimum side of the container
                int area = width * minHeight; // area of a rectangle formula
                maxArea = Math.max(area, maxArea); // taking max so we can know the max container size

            }

        }

        return maxArea;
    }
}
