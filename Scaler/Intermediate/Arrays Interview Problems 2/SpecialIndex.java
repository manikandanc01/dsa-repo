import java.util.ArrayList;

/*
 Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing 
an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints

1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109


Input Format

First argument contains an array A of integers of size N

Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Example Input

Input 1:
A = [2, 1, 6, 4]
Input 2:
A = [1, 1, 1]

Example Output

Output 1:
1
Output 2:
3

Example Explanation

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 

Explanation 2:
Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.
 */

public class SpecialIndex {
    public int solve(ArrayList<Integer> A) {
        // Brute force is try removing each element from the array and take the odd sum
        // and even sum
        // And then take the count.

        // for(i=0 -> n)
        // create new array -> copy the element from A to new array by skipping ith
        // index element
        // take odd sum, even sum
        // update count
        // Tc is : O(n^2), Sc: O(n). Because of extra array to store the elements

        // Space optimization:
        // Instead of create new array
        // for(j=0 -> i-1)
        // if(j%2 == 0) evenSum += A[j], else oddSum += A[j];
        // for(j=i+1 -> n-1)
        // if(j%2 == 0) oddSum += A[j], els evenSum += A[j];
        // Because after removing a element, before the element the index will be same.
        // After the index, even index -> odd index, and odd index to even index
        // Tc: O(n^2), Sc is O(1)

        // Optimized approach using Prefix even sum and odd sum.
        // Tc: O(n), Sc: O(n)

        int n = A.size();
        int[] evenSum = new int[n];
        int[] oddSum = new int[n];

        evenSum[0] = A.get(0);
        oddSum[0] = 0;

        for (int i = 1; i < n; i++) {
            evenSum[i] = evenSum[i - 1];
            oddSum[i] = oddSum[i - 1];

            if (i % 2 == 0) {
                evenSum[i] += A.get(i);

            } else {
                oddSum[i] += A.get(i);

            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {

            int es = oddSum[n - 1] - oddSum[i];
            int os = evenSum[n - 1] - evenSum[i];

            if (i != 0) {
                es += evenSum[i - 1];
                os += oddSum[i - 1];
            }

            if (es == os) {
                count += 1;
            }
        }

        return count;

        // We can further optimize the space to O(1), Tc is O(n)
        /*
         * int n = A.size();
         * int evenSum = A.get(0);
         * int oddSum = 0;
         * 
         * for (int i = 1; i < n; i++) {
         * if (i % 2 == 0) {
         * evenSum += A.get(i);
         * } else {
         * oddSum += A.get(i);
         * }
         * }
         * 
         * int currEvenSum = 0;
         * int currOddSum = 0;
         * int newEvenSum = 0;
         * int newOddSum = 0;
         * 
         * int count = 0;
         * for (int i = 0; i < n; i++) {
         * if (i % 2 == 0) {
         * currEvenSum += A.get(i);
         * newEvenSum = (currEvenSum - A.get(i)) + (oddSum - currOddSum);
         * newOddSum = currOddSum + (evenSum - currEvenSum);
         * } else {
         * currOddSum += A.get(i);
         * newOddSum = (currOddSum - A.get(i)) + (evenSum - currEvenSum);
         * newEvenSum = currEvenSum + (oddSum - currOddSum);
         * }
         * 
         * if (newEvenSum == newOddSum) {
         * count++;
         * }
         * }
         * return count;
         * 
         * 
         */

    }
}