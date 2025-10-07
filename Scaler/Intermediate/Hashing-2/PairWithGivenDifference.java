import java.util.HashMap;

/*
 * Problem Description

Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.

Return 1 if any such pair exists else return 0.



Problem Constraints

1 <= N <= 105
-103 <= A[i] <= 103
-105 <= B <= 105


Input Format

First argument is an integer array A of size N.

Second argument is an integer B.



Output Format

Return 1 if any such pair exists else return 0.



Example Input

Input 1:

 A = [5, 10, 3, 2, 50, 80]
 B = 78
Input 2:

 A = [-10, 20]
 B = 30
Input 2=3:

 A = [-100, 20, 80]
 B = 9


Example Output

Output 1:

 1
Output 2:

 1
Output 3:

 0
 */

public class PairWithGivenDifference {
     public int solve(int[] A, int B) {
       HashMap<Integer,Integer> hash = new HashMap<>();

       for(int num : A){
           int req = B+num;
           int req2 = num-B;
           if(hash.containsKey(req)){
              return 1;
           }
           if(hash.containsKey(req2)){
              return 1;
           }

           hash.put(num,hash.getOrDefault(num,0)+1);
       }

       return 0;
    }
}
