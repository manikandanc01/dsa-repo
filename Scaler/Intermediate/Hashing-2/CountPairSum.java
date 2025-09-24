/*
 * Problem Description

You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109


Input Format

First argument A is an array of integers and second argument B is an integer.


Output Format

Return an integer.


Example Input

Input 1:

A = [3, 5, 1, 2]
B = 8
Input 2:

A = [1, 2, 1, 2]
B = 3


Example Output

Output 1:

1
Output 2:

4


Example Explanation

Example 1:

The only pair is (1, 2) which gives sum 8
Example 2:

The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4). 
 */

import java.util.HashMap;

public class CountPairSum {
       public int solve(int[] A, int B) {
    // Brute force is consider all pairs
    // Tc will be O(n^2), Sc O(1)
    // TLE
    // int n = A.length;
    // long count = 0L;
    // int mod = (int)(1e9 + 7);
    // for(int i=0; i<n; i++){
    //     for(int j=i+1;j<n; j++){
    //         int sum = A[i]+A[j];
    //         if(sum == B){
    //             count = (count+1)%mod;
    //         }
    //     }
    // }
    // return (int)count;


    // Better Approach: Sort the Array
    // Use two pointers: one at the start and one at the end
    // if sum > B, j--. If sum < B, i++, have to handle the duplicates
    // Tc : O(n logn), Sc : O(1)
    //      int mod = 1000000007;
    // Arrays.sort(A);
    // int n = A.length;
    // long count = 0;
    
    // int i = 0, j = n - 1;
    
    // while (i < j) {
    //     int sum = A[i] + A[j];
        
    //     if (sum == B) {
    //         if (A[i] == A[j]) {
    //             long num = j - i + 1;
    //             count += (num * (num - 1) / 2) % mod;
    //             count %= mod;
    //             break;
    //         } else {
    //             int cnt1 = 1, cnt2 = 1;
    //             while (i + 1 < j && A[i] == A[i + 1]) { cnt1++; i++; }
    //             while (j - 1 > i && A[j] == A[j - 1]) { cnt2++; j--; }
                
    //             count += (cnt1 * 1L * cnt2) % mod;
    //             count %= mod;
                
    //             i++;
    //             j--;
    //         }
    //     } else if (sum < B) {
    //         i++;
    //     } else {
    //         j--;
    //     }
    // }
    
    // return (int)count;

        // Best approach: Using HashMap
        // Tc will be O(n), sc => O(n)
        int n = A.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        long count = 0L;
        int mod = (int)(1e9 + 7);

        for(int i=0; i<n; i++){
            int key = B-A[i];
            if(hash.containsKey(key)){
                int value = hash.get(key);
                count = (count+value)%mod;
            }
            hash.put(A[i],hash.getOrDefault(A[i],0)+1);
        }

        return (int)count;
    }
    
}
