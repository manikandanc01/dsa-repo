/*
 * Problem Description

Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.


Problem Constraints

 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000


Input Format

The first argument given is the integer array A.
The second argument given is integer B.


Output Format

Return the total number of subarrays having sum equals to B.


Example Input

Input 1:
A = [1, 0, 1]
B = 1
Input 2:
A = [0, 0, 0]
B = 0


Example Output

Output 1:
4
Output 2:
6
 */

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
     public int solve(int[] A, int B) {
        // Brute force: Consider all subarrays
        // Tc -> O(n^3) -> O(n^2), Sc: O(1)

        Map<Integer, Integer> hash = new HashMap<>();
        int n = A.length;

        int sum = 0; 
        int count = 0;
        for(int i=0; i<n; i++){
            sum += A[i];
            if(sum == B){
                count++;
            }

            if(hash.containsKey(sum-B)){
                 count += hash.get(sum-B);
            }

            hash.put(sum, hash.getOrDefault(sum,0)+1);
        }

        return count;
    }
    
}
