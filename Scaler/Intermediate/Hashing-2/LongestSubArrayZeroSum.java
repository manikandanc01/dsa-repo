/*
 * Problem Description

Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.



Problem Constraints

1 <= N <= 105
-109 <= A[i] <= 109


Input Format

Single argument which is an integer array A.


Output Format

Return an integer.


Example Input

Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output

Output 1:

3
Output 2:

0


Example Explanation

Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubArrayZeroSum {
    public int solve(ArrayList<Integer> A) {
        // Brute Force:
        // Consider all subarrays -> Find Sum -> If zero, if j-i+1> ans, ans = j-i+1
        // Tc is O(n^3), Sc is O(1)

        // Better Approach: Use carry forward to reduce time complexity to O(n^3), Sc ->
        // O(1)

        // Best Approach: Using HashMap. S1+S2 = S3. If S3 is equal to S1 or S2, there
        // will be one sum which is equal to zero.
        // Tc is O(N), Sc is O(N)
        int n = A.size();
        HashMap<Long, Integer> freq = new HashMap<>();

        int ans = 0;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            sum += num;
            if (sum == 0) {
                ans = Math.max(ans, i + 1);
            } else {
                if (freq.containsKey(sum)) {
                    ans = Math.max(ans, i - freq.get(sum));
                } else {
                    freq.put(sum, i);
                }
            }
        }

        return ans;
    }

}
