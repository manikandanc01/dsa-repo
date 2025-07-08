/*
 Problem Description

Given an array of size N, find the majority element.
The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array

Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109

Example Input

Input 1:
[2, 1, 2]
Input 2:
[1, 1, 1]


Example Output

Input 1:
2
Input 2:
1
 */

import java.util.List;

public class MajorityElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        // Brute force:
        // for each element, iterate over entire array and take the count.
        // for i=0 -> n
        // count = 1
        // for(j=i+1 -> n)
        // if A[j] == A[i] -> count+=1
        // if count > n/2 return A[i]
        // if array size is n, there is a possibility for only one majority element
        // which is greater than n/2
        // Tc: O(n^2), Sc : O(1)

        // Better approach:
        // Instead of two loops: Use hashMap to store the frequency of the element.
        // If any of the element frequency is greater than n/2 return that element.
        // Tc: O(n), Sc: O(n)

        /*
         * int n = A.size();
         * Map<Integer,Integer> hash = new HashMap<>();
         * for(Integer num : A){
         * if(!hash.containsKey(num)){
         * hash.put(num,0);
         * }
         * hash.put(num,hash.get(num)+1);
         * if(hash.get(num) > n/2){
         * return num;
         * }
         * }
         * 
         * return -1;
         * 
         */

        // Space Optimization:
        // Idea behind this approach is if an element is a majority element, that will
        // be have more count in final.
        // Others reduce the majorityof the element.
        // But finally majority element will wins.

        int n = A.size();
        int currentMajorityElement = A.get(0);
        int count = 1;

        for (int i = 1; i < n; i++) {
            int element = A.get(i);
            if (currentMajorityElement == element) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                currentMajorityElement = element;
                count = 1;
            }
        }

        count = 0;
        for (Integer num : A) {
            if (num == currentMajorityElement) {
                count++;
            }
        }

        if (count > n / 2) {
            return currentMajorityElement;
        }

        return -1;

    }
}