/*
 * Problem Description

Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.



Problem Constraints

2 <= N <= 105

-109 <= A[i] <= 109



Input Format

The first and only argument is an integer array A of size N.



Output Format

Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.



Example Input

Input 1:

 A = [3, 5, 1]
Input 2:

 A = [2, 4, 1]


Example Output

Output 1:

 1
Output 2:

 0
 */

package Scaler.Intermediate.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class ArithmeticProgression {
    public int solve(ArrayList<Integer> A) {
        // Tc is : O(N log n) + O(n), Sc is O(1)
        Collections.sort(A);
        int d = Integer.MIN_VALUE;
        for (int i = 1; i < A.size(); i++) {
            int diff = A.get(i) - A.get(i - 1);
            if (i != 1 && d != diff) {
                return 0;
            }
            d = diff;
        }

        return 1;
    }

}
