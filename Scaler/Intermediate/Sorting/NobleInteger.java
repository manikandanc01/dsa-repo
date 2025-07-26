package Scaler.Intermediate.Sorting;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Problem Description

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.


Problem Constraints

1 <= |A| <= 2*105
-108 <= A[i] <= 108


Input Format

First and only argument is an integer array A.



Output Format

Return 1 if any such integer p is present else, return -1.



Example Input

Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output

Output 1:

 1
Output 2:

 -1
 */

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        // Brute Force:
        // for(i=0 -> n)
        // for(j=0 -> n)
        // skip i th element
        // count elements>A[i]
        // if count == A[i] return 1;
        // return -1;
        // Tc is O(n*n), Sc is O(1)

        /*
         * int n = A.size();
         * for(int i=0; i<n; i++){
         * int count = 0;
         * for(int j=0;j<n; j++){
         * if(j==i){
         * continue;
         * }
         * 
         * if(A.get(j) > A.get(i)){
         * count++;
         * }
         * }
         * 
         * if(count == A.get(i)){
         * return 1;
         * }
         * }
         * 
         * return -1;
         */

        // Optimized approach:
        // Sort the array:
        // Iterate over the array, if(A[i] == n-i-1) return 1; else return -1
        // Tc is O(n log n) + O(n), Sc is O(1)

        Collections.sort(A);
        // for(int num : A){
        // System.out.println(num + " ");
        // }

        int n = A.size();
        for (int i = 0; i < n; i++) {
            if ((i + 1) < n && A.get(i).equals(A.get(i + 1))) {
                continue;
            }
            int value = A.get(i);
            if (value == (n - i - 1)) {
                // System.out.println(value+" "+(n-i-1));
                return 1;
            }
        }

        return -1;

    }
}