/*
 * Problem Description

Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.


Problem Constraints

1 <= Length of array B <= 105
0 <= Bi <= 109
0 <= A <= 109


Input Format

First argument A is the Target sum, and second argument is the array B


Output Format

Return an integer value 1 if there exists such pair, else return 0.

Example Input
Input 1:
A = 8   
B = [3, 5, 1, 2, 1, 2]
Input 2:

A = 21   
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]


Example Output

Output 1:
1
Output 2:
0

Example Explanation

Example 1:
It is possible to obtain sum 8 using 3 and 5.
Example 2:
There is no such pair exists.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckPairSum {
    public int solve(int A, ArrayList<Integer> B) {
        // Brute Force: Consider All pairs.
        // Tc is O(n^2), Sc is O(1), TLE

        // int n = B.size();
        // for(int i=0; i<n; i++){
        // for(int j=i+1; j<n; j++){
        // int sum = B.get(i) + B.get(j);
        // if(sum == A){
        // return 1;
        // }
        // }
        // }

        // return 0;

        // Better Approach: Sorting + Two pointers
        // Tc is O(n log n) + O(n)
        // Collections.sort(B);
        // int i=0;
        // int j=B.size()-1;

        // while(i<j){
        // int sum = B.get(i) + B.get(j);
        // if(sum == A){
        // return 1;
        // }else if(sum < A){
        // i++;
        // }else{
        // j--;
        // }
        // }

        // return 0;

        // Best Approach: Use HashSet
        // Tc is O(N), Sc is O(N)

        Set<Integer> hash = new HashSet<>();
        for (int num : B) {
            int target = A - num;
            if (hash.contains(target)) {
                return 1;
            }

            hash.add(num);
        }

        return 0;
    }

}
