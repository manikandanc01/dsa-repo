
/*
 Problem Description

You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Note: Read-only array means that the input array should not be modified in the process of solving the problem


Problem Constraints

1 <= N <= 7*105
1 <= A[i] <= 109


Input Format

The only argument is an integer array A.


Output Format

Return an integer.


Example Input

Input 1:
[1 2 3 1 1]
Input 2:
[1 2 3]


Example Output

Output 1:
1
Output 2:
-1
 */

import java.util.List;

public class RepeatNumberNby3 {
    public int repeatedNumber(final List<Integer> a) {
        // Brute force approach
        /*
         * For each element,
         * for i=0 -> n
         * count = 0
         * for j =i; j->n
         * if a[i] == a[j] count++;
         * if count > n/3
         * return a[i]
         * 
         * Tc: O(n^2), Sc is O(1)
         * 
         */

        // Better approach is using a hashmap

        /*
         * But this will take some extra space: O(n). Tc is O(n)
         * int n = a.size();
         * Map<Integer,Integer> hash = new HashMap<>();
         * for(Integer num : a){
         * if(!hash.containsKey(num)){
         * hash.put(num,0);
         * }
         * hash.put(num,hash.get(num)+1);
         * if(hash.get(num) > n/3){
         * return num;
         * }
         * }
         * 
         * return -1;
         */

        // Better approach: Optimize space complexity: O(1), Tc: O(n)
        // atmax 2 elements whose count > n/3.
        // a new candidate affects the majority of current majority candidates
        // [3,3,3,3,1,1,1,1,2,4]
        // 1 1 1 2 3 5 7

        int n = a.size();
        int element1 = 0;
        int element2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            int currValue = a.get(i);
            if (element1 == currValue) {
                count1++;
            } else if (element2 == currValue) {
                count2++;
            } else if (count1 == 0) {
                element1 = currValue;
                count1 = 1;
            } else if (count2 == 0) {
                element2 = currValue;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // System.out.println(element1 + " "+element2);
        for (int num : a) {
            if (num == element1) {
                count1++;
            }

            else if (num == element2) {
                count2++;
            }
        }

        if (count1 > n / 3)
            return element1;
        if (count2 > n / 3)
            return element2;

        return -1;
    }
}
