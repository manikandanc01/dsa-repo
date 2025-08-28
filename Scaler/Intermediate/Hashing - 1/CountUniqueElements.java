/*
 * Problem Description

You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109


Input Format

First argument A is an array of integers.


Output Format

Return an integer.


Example Input

Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output

Output 1:
1
Output 2:
2


Example Explanation

Explanation 1:
Only the element 4 has a frequency 1.
Explanation 2:
The elements 9 and 1 has a frequncy 1.
 */




import java.util.ArrayList;
import java.util.HashMap;

public class CountUniqueElements {
       public int solve(ArrayList<Integer> A) {
        // Brute force:
        // for(i=0 -> n)
        //   for(j=0 -> n)
        //     if(i==j) continue;
        //     if(A[i] == A[j]) flag = 1; break;
        //   if flag == 0 add A[i] to ans; 
        // Tc is O(n*n).  Tc will be exceeded

        // int n = A.size();
        // int count = 0;
        // for(int i=0; i<n; i++){
        //     int flag = 0;
        //     for(int j=0; j<n; j++){
        //         if(i==j){
        //             continue;
        //         }
        //         if(A.get(i).equals(A.get(j))){
        //             flag = 1;
        //             break;
        //         }

        //     }

        //     if(flag == 0){
        //         count++;
        //     }
        // }

        // return count;



        // Better Approch: Use HashMap to store frequency
        // Iterate over map and if the frequncy is 1 increment the count. 
        // Tc will be O(n+n) -> ~O(n) and Sc is O(n)
        int n = A.size();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : A){
            // freq.put(num, freq.getOrDefault(num,0)+1);
            if(!freq.containsKey(num)){
                freq.put(num,0);
            }
            freq.put(num,freq.get(num)+1);
        }

        int count = 0;

        // for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
        //   // entry.getKey()
        //     if(entry.getValue().equals(1)){
        //        count++;
        //     }
        // }

        // for(Integer frequency : freq.values()){
        //     if(frequency.equals(1)){
        //         count++;
        //     }
        // }

        for(Integer key : freq.keySet()){
            if(freq.get(key).equals(1)){
                count++;
            }
        }

        return count;


    }  
}
