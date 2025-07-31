/*
 * Problem Description

Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.


Problem Constraints

1 <= |A| <= 105
1 <= A[i] <= 105


Input Format

The first argument is an integer array A.


Output Format

Return an integer array that is the sorted array A.


Example Input

Input 1:
A = [1, 3, 1]
Input 2:
A = [4, 2, 1, 3]


Example Output

Output 1:
[1, 1, 3]
Output 2:
[1, 2, 3, 4]
 */

package Scaler.Intermediate.Strings;

import java.util.ArrayList;

public class CountSort {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // We can also find the maximum of the array A
        // and allocate only that much space
        // then tc will be O(n) + O(n+k)
        // in the second iteration, the outer loop will run k times and the inner loop
        // will run
        // total of n times, not n times for each k.
        // Tc is O(k+n), Sc is O(k)

        int n = A.size();
        int sz = 100005;
        int[] arr = new int[sz];

        for (int i = 0; i < n; i++) {
            int value = A.get(i);
            arr[value]++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    res.add(i);
                }
            }
        }

        return res;
    }

}
