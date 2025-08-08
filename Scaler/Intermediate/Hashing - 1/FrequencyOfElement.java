/*
 * Problem Description

SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating the least, allowing them to provide targeted support and encouragement.


Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner, and an array B containing the learners for whom you want to check participation frequency, your task is to find the frequency of each learner from array B in the array A and return a list containing all these frequencies


Problem Constraints

1 <= |A| <= 105
1 <= |B| <= 105
1 <= A[i] <= 105
1 <= B[i] <= 105


Input Format

First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.


Output Format

Return an array of integers containing the frequency of each learner in B as found in array A.


Example Input

Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]


Example Output

Output 1:
[3, 1]
Output 2:
[0, 2]

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElement {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Brute force:
        // For each element in B, iterate over A and find the count.
        // Tc will be O(n*m),Sc is O(m) -> TLE

        // int n = A.size();
        // int m = B.size();

        // ArrayList<Integer> arr = new ArrayList<>();
        // for (int i = 0; i < m; i++) {
        // int count = 0;
        // for (int j = 0; j < n; j++) {
        // if (B.get(i).equals(A.get(j))) {
        // count++;
        // }
        // }

        // arr.add(count);
        // }

        // return arr;

        // Better: use HashMap to store the frequency
        // Tc is O(n+m), Sc is O(n)

        ArrayList<Integer> res = new ArrayList<>();

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int key : B) {
            res.add(freq.getOrDefault(key, 0));
        }

        return res;

        // One more Approach: 
        // Sort both the arrays. 
        // Then use 2 pointers to find the frequency of each element in B.
        // Tc is O(nlogn + mlogm + n+m), Sc is O(1) 
        // int n = A.size();
        // int m = B.size();
        // ArrayList<Integer> res = new ArrayList<>();
        // Collections.sort(A);
        // Collections.sort(B);
        // int i = 0, j = 0;
        // while (i < n && j < m) {
        //     if (A.get(i) < B.get(j)) {
        //         i++;
        //     } else if (A.get(i) > B.get(j)) {
        //         j++;
        //     } else {
        //         int count = 0;
        //         while (i < n && A.get(i) == B.get(j)) {
        //             count++;
        //             i++;
        //         }
        //         res.add(count);   
        //         j++;
        //     }
        // }    
        // while (j < m) {
        //     res.add(0);
        //     j++;
        // }
        // return res;

    }
}
