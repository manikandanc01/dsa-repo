/*
Problem Description

Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
The first and only argument is an integer array A of size N.

Output Format
Return an integer denoting the first repeating element.

Example Input
Input 1:
A = [10, 5, 3, 4, 3, 5, 6]
Input 2:
A = [6, 10, 5, 4, 9, 120]
Example Output

Output 1:
 5
Output 2:
 -1


Example Explanation

Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public int solve(ArrayList<Integer> A) {
        // We can solve this using single pass
        // Iterate the array A from right to left.
        // If the element already exist add current element as the answer else add the
        // element to the hashmap
        /*
         * 
         * HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>();
         * int ans = -1;
         * for(int i = A.size()-1; i >= 0; --i){
         * if(vis.containsKey(A.get(i))){
         * ans = A.get(i);
         * }
         * else{
         * vis.put(A.get(i), 1);
         * }
         * }
         * return ans;
         * 
         */

        // Using HashMap:
        // Tc is O(n), Sc is O(n)
        int n = A.size();
        Map<Integer, Integer> hash = new HashMap<>();

        for (int num : A) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        for (int num : A) {
            if (hash.get(num) > 1) {
                return num;
            }
        }

        return -1;

        // Better Approach: Use Sorting
        // Copy the elements from the Array A to temp Array
        // Sort the temp array.
        // iterate over each element in the A and get the count of element from temp
        // array using binary search.
        // tc is O(n log n), sc is O(n)

        // Brute force: Consider all valid pairs
        // Each element check it is repeating or not.
        // Tc is O(n^2), Sc is O(1)

        // for(int i=0; i<A.size(); i++){
        // for(int j=i+1; j<A.size(); j++){
        // if(A.get(i).equals(A.get(j))){
        // return A.get(i);
        // }
        // }
        // }

        // return -1;
    }

}
