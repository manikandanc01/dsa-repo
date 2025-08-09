/*
 * Problem Description

Given an array A of N integers, return the number of unique elements in the array.


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109


Input Format

First argument A is an array of integers.


Output Format

Return an integer.


Example Input

Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output

Output 1:
3
Output 2:
4
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {
    public int solve(ArrayList<Integer> A) {
        // Brute Force:
        /*
         * Iterate over each element, if the current element is not encountered earlier
         * add to the count, else don't add
         * 
         * Tc is O(n^2) and Sc is O(1)
         * 
         * count = 0;
         * for(i=0 -> n-1){
         * boolean isDuplicate = false;
         * for(j = 0 -> i-1){
         * if(A[i] == A[j]){
         * isDuplicate = true;
         * break;
         * }
         * }
         * 
         * if(!isDuplicate){
         * count++;
         * }
         * }
         * 
         * return count;
         */

        // Better approach:
        /*
         * Sort the array:
         * Iterate over the array, if the current element not equal to previous element
         * count++
         * Else retain the same count.
         * 
         * Tc is O(n logn), Sc is O(1)
         * 
         * Pseudocode:
         * 
         * if(A.size() == 0) return 0;
         * Collections.sort(A);
         * int count = 1;
         * for(int i=1; i<n; i++){
         * if(A[i] == A[i-1]){
         * continue;
         * }
         * count++;
         * }
         * 
         * return count;
         * 
         */

        // Better approach: insert all elements into the set and return the size of the
        // set
        int n = A.size();
        Set<Integer> set = new HashSet<>();

        for (int num : A) {
            set.add(num);
        }

        return set.size();
    }

}
