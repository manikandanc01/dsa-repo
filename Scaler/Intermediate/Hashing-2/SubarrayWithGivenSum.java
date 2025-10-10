/*
 * Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".

Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output

Output 1:
 [2, 3]
Output 2:

 [-1]

Example Explanation

Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
 */


public class SubarrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        // Brute force : Consider all subarrays -> find the sum, check it is equal to B or not
        // Tc is: O(n^3), sc is O(n)

        // Approach 2: use carry forward to calculate the running sum
        // Tc is O(n^2), Sc is O(n)

        // Approach 3: Use Prefix sum (carry forward) + HashMap
        // [1,2,3,4,5]
        // [1, 3, 6, 10, 15] -> if (sum - B) exists in hashMap, we can break the loop. 
        // Tc O(n), Sc is O(n)

        // This problem: No need for HashMap, can use dynamic sliding window approach. 

        int n = A.length;
       
        int r = 0;
        int l = 0;
        long sum = A[l];

        while(r < n && l<=r){
            if(sum == B){
               int result[] = new int[r-l+1];
               int idx = 0;
               for(int i=l; i<=r; i++){
                   result[idx++] = A[i];
               }
               return result;
            }else if(sum < B){
                r++;
                if(r<n){
                    sum += A[r];
                }
            }else{
                sum -= A[l];
                l++;
                if(l>r && l < n-1){
                    r++;
                    sum += A[r];
                }
            }
        }

        return new int[]{-1};



        // int n = A.length;
        // int startIndex = -1;
        // int endIndex = -1; 


        // HashMap<Long, Integer> hash = new HashMap<>();
        // long pfSum = 0L;
        
        // for(int i=0; i<n; i++){
        //     pfSum += A[i];
        //     long hashKey = pfSum - (long)B;

        //     if(hashKey == 0L){
        //        startIndex = 0;
        //        endIndex = i;
        //        break;
        //     }

        //     if(hash.containsKey(hashKey)){
        //         startIndex = hash.get(hashKey) + 1;
        //         endIndex = i;
        //         break;
        //     }

        //     hash.put(pfSum, i);
        // }

        // if(startIndex == -1 && endIndex == -1){
        //     return new int[]{-1};
        // } 

        // int result[] = new int[endIndex-startIndex+1];
        // int idx = 0;
        // for(int i=startIndex; i<= endIndex; i++){
        //     result[idx++] = A[i];
        // }

        // return result;
    } 
}
