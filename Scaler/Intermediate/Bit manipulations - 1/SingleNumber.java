/*
 * Problem Description

Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



Problem Constraints

1 <= |A| <= 2000000

0 <= A[i] <= INTMAX



Input Format

The first and only argument of input contains an integer array A.



Output Format

Return a single integer denoting the single element.



Example Input

Input 1:

 A = [1, 2, 2, 3, 1]
Input 2:

 A = [1, 2, 2]


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

3 occurs once.
Explanation 2:

1 occurs once.
 */


public class SingleNumber {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) { 
      /*
         Brute Force:
          1. For each element, iterate over all other elements, if the current element count is 1
          return that element. Tc: O(n^2), Sc: O(1).

          2nd Approach:
          1. Sort the array. Iterate over the array, if the neighbour element is not the current element, return
          Tc is O(n log n)+O(n), Sc is O(1)

          3rd Approach:
          1. Use hashmap to store the frequency of each element. 
          2. Iterate over hashmap, if any element frequency is equal to 1 return that element. 

          Tc is O(n), Sc is O(n).

          4rth Approach:
          1. Use xor concept of Bit manipulation
          2. Xor of same element results to 0. a^0 is a.

          Tc is O(n), Sc is O(1)
      */

     /* int n = A.length;
      Map<Integer, Integer> frequency = new HashMap<>();
      for(int num : A){
          if(!frequency.containsKey(num)){
              frequency.put(num,0);
          }
          frequency.put(num, frequency.get(num)+1);
      }


      int result = -1;

      for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
          if(entry.getValue() == 1){
              result = entry.getKey();
          }
      }

      return result;*/

      int n = A.length;
      int result = 0;
      for(int i=0; i<n; i++){
          result ^= A[i];
      }
      return result;
    }
}