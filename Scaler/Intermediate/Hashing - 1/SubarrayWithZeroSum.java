/*
 * Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.




Problem Constraints

1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9




Input Format

The only argument given is the integer array A.



Output Format

Return whether the given array contains a subarray with a sum equal to 0.



Example Input

Input 1:


 A = [1, 2, 3, 4, 5]


Input 2:

















 A = [4, -1, 1]











Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The subarray [-1, 1] has sum 0.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
    public int solve(ArrayList<Integer> A) {
        // Just write your code below to complete the function. Required input is
        // available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this
        // function.

        // Brute Force: Consider all subarrays. Calcualte the sum, check the sum is 0.
        // If 0 return 1, else return 0
        // Time complexity: O(n^3), Sc is O(1)

        /*
         * Pesudocode
         * for(i=0 -> n-1){
         * for(j=i -> n-1){
         * sum = 0;
         * for(k=i->j){
         * sum+=A[k];
         * }
         * 
         * if(sum == 0){
         * return 1;
         * }
         * }
         * }
         * 
         * return 0;
         * 
         */

        // Better Approach: Use Prefix sum to find the sum in O(1),
        // Tc is O(n^2), Sc is O(n), To avoid extra space use carry forward sum instead
        // of prefix sum
        /*
         * Pesudocode:
         * for(i=0 -> n-1){
         * sum = 0;
         * for(j=i -> n-1){
         * sum += A[j];
         * if(sum == 0){
         * return 1;
         * }
         * }
         * }
         * 
         * return 0;
         * 
         */

        /*
         * Optimized Appraoch:
         * [1,-5,2,4,-1,3]
         * 
         * let's store the sum while iterating over the array.
         * 
         * prefixsumArray => [1, -4, -2, 2, 1, 4]
         * Here if we see, 1 is coming two times which means the sum between index 1 to
         * 4 is 0.
         * 
         * S3 = S1 + S2
         * If(S3 == S1) -> S2 = 0
         * 
         * Tc is O(n), Sc is O(n) to store the sum in the hashMap(to get the sum in
         * O(1))
         */

        Set<Long> hashSet = new HashSet<>();
        hashSet.add(0L);

        long sum = 0;
        for (int num : A) {
            sum += num;
            if (hashSet.contains(sum)) {
                return 1;
            }

            hashSet.add(sum);
        }

        return 0;
    }

}
