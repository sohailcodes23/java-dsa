package coderarmy.interview;

//#interview
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 5, 2, 6, 2, 3};
//        int[] height = {4, 2, 0, 3, 2, 5};
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("ANS " + trap_Optimised(height));
    }

    public static int trap_Optimised(int[] height) {

        //TC=> O(3N) ==> O(N)
        //SC=> O(1)
        int n = height.length;
        int maxLeftHeight = 0, maxRightHeight = 0, water = 0;
        int maxHeight = height[0], maxHeightIndex = 0;// Assuming max height in all the bars

        // Finding Max height building
        //TC=> O(N)
        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        int maxWaterAtCurrentIndex = 0;
        // Left Part of maxHeightIndex
        //TC=> O(N)
        for (int i = 0; i < maxHeightIndex; i++) {// Loop from 0 to before the maxHeight bar

            // so if maxLeftHeight < current height so it doesn't makes sense to deduct the bar, the ans will be a -ve no. and in reality it won't be able to trap anything in such scenarios so  maxLeftHeight=height[i]
            if (maxLeftHeight > height[i]) { // Only deduct bar whene maxLeftHeight > height[i]
                maxWaterAtCurrentIndex = maxLeftHeight - height[i];
                water = water + maxWaterAtCurrentIndex; // add water
            } else {
                maxLeftHeight = height[i]; // if maxLeftHeight < height[i], now that is the new maxLeftHeight
            }

        }

        maxWaterAtCurrentIndex = 0;
        // Right Part of maxHeightIndex
        //TC=> O(N)
        for (int i = n - 1; i > maxHeightIndex; i--) { // Loop from n-1 to after the maxHeight bar

            // so if maxRightHeight < current height so it doesn't makes sense to deduct the bar, the ans will be a -ve no. and in reality it won't be able to trap anything in such scenarios so  maxRightHeight=height[i]
            if (maxRightHeight > height[i]) {
                maxWaterAtCurrentIndex = maxRightHeight - height[i];
                water = water + maxWaterAtCurrentIndex;
            } else {
                maxRightHeight = height[i]; // if maxRightHeight < height[i], now that is the new maxRightHeight
            }
        }

        //Note : while calculating left and right sides we have skipped the maxHeigth bar, bcz since it's max heighted bar, it won't be able to store any water, so by default it's value is 0 and we don't need to add it in final water unit

        return water;
    }


    //Better TC but With Space, clean code
    public static int trap_Better(int[] height) {

//        TC=> O(2N) ==> O(N)
//        SC=> O(2N) ==> O(N)

        int n = height.length;
        int[] maxLeftArray = new int[n];// SC=> O(N)
        int[] maxRightArray = new int[n];// SC=> O(N)

        for (int i = 0; i < n; i++) { // TC=> O(N)
            maxLeftArray[i] = maxFromStartToEnd(0, i, height); // we need the max height building from left side from our index
            maxRightArray[i] = maxFromStartToEnd(i, n, height);// we need the max height building from right side from our index
        }

        int finalWaterUnit = 0;
        for (int i = 0; i < n; i++) { // TC=> O(N)
            int minimumSupport = Math.min(maxLeftArray[i], maxRightArray[i]);// We will consider min height from both sides bcz Only that much water can be trapped and rest of the water will flow from the other side, EX=> 4,6, so we can only fill water till 4th floor, any more water will just flow out if we try to fill till 6th
            int heightOfWaterDueToBuilding = 0;
            if (minimumSupport > height[i]) {// so if minimumSupport< current height so it doesn't makes sense to deduct the floors, the ans will be a -ve no. and in reality it won't be able to trap anything in such scenarios so the heightOfWaterDueToBuilding =0;
                // so we only deduct when minimumSupport > height[i]
                heightOfWaterDueToBuilding = minimumSupport - height[i];
            }

            finalWaterUnit = finalWaterUnit + heightOfWaterDueToBuilding;// adding all the water units
        }

        return finalWaterUnit;

    }


    static int maxFromStartToEnd(int start, int end, int[] array) {

        int max = 0;
        for (int i = start; i < end; i++) {// < end, bcz ignoring the current element
            max = Math.max(max, array[i]);
        }
        return max;
    }

    // Worse TC but without space
    public static int trap_Brute(int[] height) {

        //TC=> O(N^2)
        //SC=> O(1)

        int n = height.length;
        int water = 0;
        for (int i = 0; i < n; i++) {

            int leftSum = maxFromStartToEnd(0, i, height);// we need the max height building from left side from our index
            int rightSum = maxFromStartToEnd(i, n, height);// we need the max height building from right side from our index

            int maxWaterThatCanBeTrapped = Math.min(leftSum, rightSum);// We will consider min height from both bcz Only that much water can be trapped and rest of the water will flow from the other side, EX=> 4,6, so we can only fill water till 4th floor, any more water will just flow out if we try to fill till 6th

//APPROACH 1:
//            int heightOfWaterDueToBuilding = maxWaterThatCanBeTrapped - height[i];// SO once we get the maxWaterThatCanBeTrapped, we need to deduct the building height, EX=> If we can store till 4th floor, and the current floor is 2 floors, that means water can be trapped till 4th floor but since some space is occupied by 2 floor , we will deduct the occupied floor and now we have the water unit that can actually be trapped
//            if (heightOfWaterDueToBuilding < 0) {// so any value that goes <0, can be assigned as 0, bcz -ve water cannot be trapped
//                heightOfWaterDueToBuilding = 0;
//            }
//            water = water + heightOfWaterDueToBuilding;// adding all the water units


            //APPROACH 2:
            int heightOfWaterDueToBuilding = 0;
            if (maxWaterThatCanBeTrapped > height[i]) {// so if maxWaterThatCanBeTrapped< current height so it doesn't makes sense to deduct the floors, the ans will be a -ve no. and in reality it won't be able to trap anything in such scenarios so the heightOfWaterDueToBuilding =0;
                // so we only deduct when maxWaterThatCanBeTrapped > height[i]
                heightOfWaterDueToBuilding = maxWaterThatCanBeTrapped - height[i];
            }

            water = water + heightOfWaterDueToBuilding;// adding all the water units
        }

        return water;

    }


}
