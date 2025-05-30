[![Leetcode Stats](https://leetcard.jacoblin.cool/sohailcodes23)](https://leetcode.com/sohailcodes23/)

# Read:

https://leetcode.com/problems/minimum-window-substring/solutions/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems/

# Tips(It might not apply in all situations):

## Hashmap TC==> O(N) : worst case scenario

## Recursion: In finding all subsequences/subsets TC==> O(2^N) : worst case scenario. Generally TC is not asked for recursive questions, we can say TC is Exponential if asked more this can be derived

## Constraint Tips:

If it's said don't modify the array that means, you can't sort it or change the values

## Matrix: Since it's a matrix min TC==> O(N^2) : worst case scenario

## Two Pointers: Don't use 2 pointers when we have negative no. in array (check constraint as well)

## Sliding Window: 
1. Whenever the character frequency is greater than 1, we don’t know how many duplicates are present. So we use a loop to keep shrinking until the character count drops to 1. 

## Array solving technique:

Brute : linear search / Depends on the question \
Better : Hashing techniques \
Optimal : 2 pointers

## Matrix / Multi-dimensional solving technique:

# If we want to rotate the elements/ change its position: 1. Do Transpose(Row becomes columns and vice versa) 2. Reverse/Change the position somehow to desired location

# Transpose: {1,2},{4,5} ==> {1,4}.{2,5}

### When we want to find 2 values in a single array traverse, we use 2 pointers approach

## Kadane Algo:

While calculating sum, If sum < 0 than sum =0; And continue to calculate the sum till n-1

#### WHY: Accd to Kadane Algo, it just makes the whole sum a smaller value than the current sum, so we just make it 0

To find LargestSumContiguousSubArray : Check LargestSumContiguousSubArray_KadaneAlgo

## Any type of counting in Array: use Hashmap

TC=> For Hashmap = O(1)\
TC=> When unordered map O(N), if there is ordered map than the TC=> O(N logN)

# SHORTCUTS

## Recursion:

RF: Recursive Function \
BB: Base case

# PATTERNS

## Recursion: Options Concept: where at a index we take the index element and at the same index we don't take it, we call 2 RF functions, once after adding element in list and one after removing element from the list

## **Pseudocode:**

```java
void recursiveFunctionToGetSubsequence(int i, int arr[], List<Integer> list) {
    if (i >= n) { // Base case
        subsequenceList.add(new ArrayList<>(list));// Add in list or print all the subsequence
        return;
    }

    list.add(arr[i]); // Add to the list
    recursiveFunctionToGetSubsequence(i + 1, arr, list); // RF1: Take the element

    list.remove(list.size() - 1); // Remove last element to backtrack
    recursiveFunctionToGetSubsequence(i + 1, arr, list); // RF2: Don't take the element
}