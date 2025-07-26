package Scaler.Intermediate.Sorting;

/*
 * Problem Description
 
 Given an integer array A of size N. You can remove any element from the array in one operation.
 The cost of this operation is the sum of all elements in the array present before this operation.
 
 Find the minimum cost to remove all elements from the array.
 
 
 
 Problem Constraints
 
 0 <= N <= 1000
 1 <= A[i] <= 103
 
 
 
 Input Format
 
 First and only argument is an integer array A.
 
 
 
 Output Format
 
 Return an integer denoting the total cost of removing all elements from the array.
 
 
 
 Example Input
 
 Input 1:
 
  A = [2, 1]
 Input 2:
 
  A = [5]
 
 
 Example Output
 
 Output 1:
 
  4
 Output 2:
 
  5
 
 
 Example Explanation
 
 Explanation 1:
 
  Given array A = [2, 1]
  Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
  Remove 1 from the array => []. Cost of this operation is (1) = 1.
  So, total cost is = 3 + 1 = 4.
 Explanation 2:
 
  There is only one element in the array. So, cost of removing is 5.
 */

import java.util.ArrayList;
import java.util.Collections;

public class ElementsRemoval {
    public int solve(ArrayList<Integer> A) {
        // Brute Force:
        // Sort the array:
        // Iterate the array from the n-1 => 0
        // Iterate and calculate the sum from j=0 to j=i
        // Tc: O(n log n) + O(n*n), Sc is O(1)
        // To reduce the cost we have to remove the greater elements first from the
        // array.

        // Better approach: Instead of calculating the sum again and again use prefix
        // sum Array
        // Tc is O(n logn) + O(n) + O(n), (sorting + prefix sum calculation + result
        // calculation)
        // Sc is O(n) for storing the precalculated value.

        // Space optimization: Instead of creating the array, just use carry forward.

        /*
         * int n = A.size();
         * Collections.sort(A);
         * 
         * int sum = 0;
         * for(int num : A){
         * sum += num;
         * }
         * 
         * int result = 0;
         * for(int i=n-1; i>=0; i--){
         * result += sum;
         * sum = sum - A.get(i);
         * }
         * 
         * return result;
         */

        /*
         * We can avoid that extra O(n) by using the contribution technique.
         * Starting from greater value, they are contributing to the total sum very less
         * number of times
         * Then only we get lesser cost
         * 
         * Sort the array,
         * mincost+=A[n-1]*(n-i)
         * 
         * Tc is O(n log n) + O(n), Sc is O(1)
         * 
         */

        int n = A.size();
        Collections.sort(A);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A.get(i) * (n - i);
        }

        return result;
    }
}
