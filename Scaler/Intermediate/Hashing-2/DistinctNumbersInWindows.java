/*
 * 

Problem Description

You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE: if B > N, return an empty array.

Problem Constraints
1 <= N <= 106
1 <= A[i] <= 109

Input Format

First argument is an integer array A
Second argument is an integer B.

Output Format
Return an integer array.

Example Input
Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:
 A = [1, 1, 2, 2]
 B = 1

Example Output
Output 1:
 [2, 3, 3, 2]
Output 2:
 [1, 1, 1, 1]

Example Explanation
Explanation 1:
 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:
 Window size is 1, so the output array is [1, 1, 1, 1].
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindows {
     public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        
        // Brute force:
        // for n-B+1 windows, B elements have to be checked. 
        // O((n-B+1)*B), At worst B expands upto n. O(n*n)
        // Tc is O(n^2) and Sc is O(n). TLE
        // int i = 0;
        // int j = B-1;

        // ArrayList<Integer> res = new ArrayList<>();
        // while(j<n){
        //     HashSet<Integer> uniq = new HashSet<>();
        //     for(int k=i; k<=j; k++){
        //         uniq.add(A.get(k));
        //     }

        //     res.add(uniq.size());
        //     i++;
        //     j++;
        // }

        // return res;


        // Optimized version: Sliding window + HashMap
        // Tc is O(n), Sc is O(B)

        int i=0;
        int j=B-1;
        ArrayList<Integer> res = new ArrayList<>();

        Map<Integer, Integer> uniq = new HashMap<>();
        for(int k=i; k<=j; k++){
            int value = A.get(k);
            uniq.put(value, uniq.getOrDefault(value,0)+1);
        }
       
        j++;
        res.add(uniq.size());
        while(j<n){
            int currValue = A.get(j);
            int oldValue = A.get(i);
            uniq.put(currValue, uniq.getOrDefault(currValue,0)+1);
            uniq.put(oldValue,uniq.get(oldValue)-1);

            if(uniq.get(oldValue).equals(0)){
                uniq.remove(oldValue);
            }

            res.add(uniq.size());
            i++;
            j++;
        }

        return res;
    }
}
