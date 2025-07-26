package Scaler.Intermediate.Sorting;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Problem Description

You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.

Note: You cannot use any extra space


Problem Constraints

1 <= N <= 104
1 <= A[i] <= 104


Input Format

First argument A is an array of integers.


Output Format

Return an array of integers.


Example Input

Input 1:
A = [6, 8, 9]
Input 2:
A = [2, 4, 7]


Example Output

Output 1:
[9, 6, 8]
Output 2:
[2, 7, 4]
 */

public class FactorsSort {
    class Pair {
        int num;
        int factor;

        Pair(int a, int b) {
            this.num = a;
            this.factor = b;
        }
    }

    public int countOfFactors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // Brute force: Count the factors, create a pair, sort based on the factor, if
        // same sort based on number
        // Tc is O(n*sqrt(n))+O(n logn)+O(n), sc is O(n)

        // Space Optimization: Instead of creating a pair, we can directly sort inside
        // the comparotor function itself
        // Tc is O(n logn * sqrt(A[i])), Sc is O(1) -> no extra space is used.

        int n = A.size();
        Collections.sort(A, (a, b) -> {
            int factor1 = countOfFactors(a);
            int factor2 = countOfFactors(b);

            if (factor1 == factor2) {
                return a - b;
            }
            return factor1 - factor2;
        });

        return A;
        /*
         * Pair[] arr = new Pair[n];
         * for(int i=0; i<n; i++){
         * int factorCount = countOfFactors(A.get(i));
         * // System.out.println(A.get(i)+" "+factorCount);
         * Pair p = new Pair(A.get(i), factorCount);
         * arr[i] = p;
         * }
         * 
         * 
         * Arrays.sort(arr, (a,b)->{
         * if(a.factor == b.factor){
         * return a.num - b.num;
         * }
         * return a.factor-b.factor;
         * });
         * 
         * ArrayList<Integer> res = new ArrayList<>();
         * for(int i=0; i<n; i++){
         * res.add(arr[i].num);
         * }
         * 
         * return res;
         */
    }

}
