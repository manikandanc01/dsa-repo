/*
 * 
 * Problem Description

You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.


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
B = 4
Input 2:

A = [1, 2, 1, 2]
B = 1


Example Output

Output 1:

1
Output 2:

4


Example Explanation

Example 1:

The only pair is (2, 3) which gives difference as 4
Example 2:

The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).
 */

import java.util.HashMap;

public class CountPairDifferen {
    public int solve(int[] A, int B) {
         // Brute Force
       // Consider all pairs
       // TLE, Tc: O(n^2), sc : O(1)

       // Better Approach:
       // Sort the Array: 
       // i =0, j=1, if(A[j]-A[i] < B, j++, else i++
       // Tc is O(n logn), sc is O(1)

       // Optimized approach: Using HashMap

       int mod =(int) 1e9 + 7;
       long count = 0L;
       HashMap<Integer,Integer> hash = new HashMap<>();

       for(int num : A){
           int req = B+num;
           int req2 = num-B;
           if(hash.containsKey(req)){
               count = (count + hash.get(req))%mod;
           }
           if(hash.containsKey(req2)){
               count = (count + hash.get(req2))%mod;
           }

           hash.put(num,hash.getOrDefault(num,0)+1);
       }

       return (int)count%mod;

      /* for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               if(i==j){
                   continue;
               }

               if(A[i]-A[j] == B){
                   count = (count + 1)%mod;
               }
           }
       }

       return (int)count%mod;
       */
    }
}