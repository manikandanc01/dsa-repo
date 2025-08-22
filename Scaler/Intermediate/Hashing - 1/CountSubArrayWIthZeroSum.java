/*
 * Problem Description

Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


Problem Constraints

1 <= N <= 105
-109 <= A[i] <= 109


Input Format

Single argument which is an integer array A.


Output Format

Return an integer.


Example Input

Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output

Output 1:

3
Output 2:

1


Example Explanation

Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWIthZeroSum {
    // Brute force: consider all subarrays, check if sum is zero
    // Tc is O(n^3), Sc is O(1)

    // Use prefix sum for find the sum in O(n^2)
    // Tc is O(n^2), Sc is O(1)

    // Use HashMap to store the prefix sum and its frequency
    // Tc is O(n), Sc is O(n)
    public int solve(ArrayList<Integer> A) {
        Map<Long, Long> freq = new HashMap<>();

        freq.put(0L, 0L);
        int mod = 1000000007;
        Long count = 0L;
        Long sum = 0L;

        for (int num : A) {
            sum += num;
            if (!freq.containsKey(sum)) {
                freq.put(sum, 1L);
            } else {
                if (sum == 0) {
                    count += freq.get(sum) + 1;
                } else {
                    count += freq.get(sum);
                }

                freq.put(sum, freq.get(sum) + 1);
            }

        }

        return (int) (count % mod);
    }

}
