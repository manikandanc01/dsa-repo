/*
 * Problem Description

Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.


NOTE:


Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints

1 <= N, M <= 105

1 <= A[i] <= 109



Input Format

First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format

Return an integer array denoting the common elements.



Example Input

Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output

Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation

Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Just write your code below to complete the function. Required input is
        // available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this
        // function.


        // Brute Force approach is:
        // For each element in A, check if it exists in B
        // Tc is O(n*m), sc is O(n)
        // Needs to be careful in marking the element which already taken into count. 
        // use one extra visited array

        

        // Better Approach: Sort both the ArrayList
        // Tc is O(n log n + m log m), sc is O(number of common elements)

    
    /*  int n = A.size();
        int m = B.size();

        Collections.sort(A);
        Collections.sort(B);

        int i=0;
        int j=0;

        ArrayList<Integer> arr = new ArrayList<>();

        while(i<n && j<m){
            int valueA = A.get(i);
            int valueB = B.get(j);
            if(valueA == valueB){
                 arr.add(valueA);
                 i++;
                 j++;
            }else if(valueA < valueB){
                 i++;
            }else{
                j++;
            }
        }

        return arr; */

        // Optimized approach
        // Using HashMap
        // Tc: O(n+m), sc: O(n)

        ArrayList<Integer> res = new ArrayList<>();

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : B) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                res.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        return res;
    }
}
