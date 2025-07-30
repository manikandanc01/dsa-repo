/*
 * 
 * Problem Description

Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.

If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.


Problem Constraints

1 <= N <= 105

1 <= A[i] <= 109



Input Format

First argument A is an array of integers.



Output Format

Return the array after sorting



Example Input

Input 1:
A = [15, 11, 7, 19]
Input 2:
A = [2, 24, 22, 19]


Example Output

Output 1:
[7, 19, 15, 11]
Output 2:
[2, 19, 24, 22]
 */

package Scaler.Intermediate.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class TensDigitSorting {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        /*
         * Behind the scenes, it uses TimSort (a hybrid of merge + insertion sort).
         * It calls the comparator like compare(a, b) to decide the order.
         * 
         * The rule is:
         * 
         * If compare(a, b) < 0, then a comes before b
         * If compare(a, b) > 0, then b comes before a
         * If compare(a, b) == 0, they are equal in order
         * 
         * Tc is O(N log N), Sc is O(1)
         * 
         */
        Collections.sort(A, (a, b) -> {
            int tensDigitOfA = getTensPlaceDigit(a);
            int tensDigitOfB = getTensPlaceDigit(b);

            if (tensDigitOfA == tensDigitOfB) {
                return b - a; // descending order based on the entire number
            }

            return tensDigitOfA - tensDigitOfB; // ascending order based on the tens digit.
        });

        return A;
    }

    public int getTensPlaceDigit(int num) {
        int ans = 0;
        int count = 1;

        while (num > 0) {
            int r = num % 10;
            if (count == 2) {
                return r;
            }
            count++;
            num /= 10;
        }

        return ans;
    }

}
