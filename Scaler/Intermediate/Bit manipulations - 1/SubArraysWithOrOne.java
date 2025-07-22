/*
 * 
 * Problem Description

Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
Note : The answer can be large. So, return type must be long.



Problem Constraints

1 <= A <= 105


Input Format

The first argument is a single integer A.
The second argument is an integer array B.


Output Format

Return the number of subarrays with bitwise array 1.


Example Input

Input 1:
 A = 3
B = [1, 0, 1]
Input 2:
 A = 2
B = [1, 0]


Example Output

Output 1:
5
Output2:
2
 */


public class SubArraysWithOrOne {
    public long solve(int A, int[] B) {
      // If there is 0 continuosly, it will not contrinbute to final result
      // whenver the first 1 is encountered, from where we taken the count of endpoints
      // fixed start point and how many valid endpoints.
      // while we encounter the value 1, the endpoints are not valid for every start point
      // once we encounter the one, after that all are valid endpoints. 
      // Tc is O(n), Sc is O(1)

      long ans = 0;
      int n = A;
      for(int i=0; i<n; i++){
          if(B[i]==0){
               int start = i;
              while(i<A && B[i]==0){
                  i++;
              }

              ans += (long)(i-start)*(n-i);
              i--;
          }else{
              ans+= (n-i);
          }
      }

      return ans;

    
    /*
        better solution: Tc is O(n), sc is O(1)
       totalSubArrays-totalZeroSubarrays = totalNonZeroSubArrays

       -------x-----x----------------
        long totalSubArrays = ((long)A * (A+1))/2;
        long ans = 0;
        
        for(int i=0; i<A; i++){
            if(B[i] == 1){
                continue;
            }
            
            int count = 0;
            int j=i;
            for(; j<A; j++){
                if(B[j] == 1){
                    break;
                }else{
                    count+=1;
                }
            }

            totalSubArrays-= ((long)count*(count+1))/2;
            i=j;
        }

        return totalSubArrays;
        
 ----------------x-----------------x---------------
         This is the worst case -> Brute Force: Tc is O(n*n)
        long totalSubArrays = ((long)A * (A+1))/2;
        long ans = 0;
        
        for(int i=0; i<A; i++){
            if(B[i] == 1){
                continue;
            }
            
            for(int j=i; j<A; j++){
                if(B[j] == 1){
                    break;
                }else{
                    totalSubArrays-=1;
                }
            }

        }

        return totalSubArrays;
        */

    }
}
