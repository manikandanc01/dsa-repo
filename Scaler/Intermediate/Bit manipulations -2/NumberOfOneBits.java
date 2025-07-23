/*
 * Problem Description

Write a function that takes an integer and returns the number of 1 bits present in its binary representation.


Problem Constraints

1 <= A <= 109


Input Format

First and only argument contains integer A


Output Format

Return an integer


Example Input

Input 1:
11
Input 2:
6


Example Output

Output 1:
3
Output 2:
2


Example Explanation

Explaination 1:
11 is represented as 1011 in binary.
Explaination 2:
6 is represented as 110 in binary.
 */

public class NumberOfOneBits {
    public int numSetBits(int A) {

        // (A&(A-1)) -> set the first right most set bit of A to 0 -> This is one
        // property.
        // Brian Kernighan’s Algorithm
        // Tc is O(number of set bits), faster than counting each bits.

        int count = 0;
        while (A > 0) {
            A = A & (A - 1);
            count++;
        }

        return count;

        /*
         * Tc is O(log A), sc is O(1)
         * int shiftIndex = 0;
         * int count = 0;
         * 
         * while((1<<shiftIndex) <= A){
         * if((A&(1<<shiftIndex))!=0){
         * count++;
         * }
         * shiftIndex++;
         * }
         * 
         * return count;
         */
    }
}
