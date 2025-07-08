
/*
 Problem Description

You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.


Problem Constraints

0 <= A <= 109
2 <= B <= 9


Input Format

First argument A is an integer.
Second argument B is an integer.


Output Format

Return an integer.


Example Input

Input 1:
A = 1010
B = 2
Input 2:
A = 22 
B = 3


Example Output

Output 1:
10
Output 2:
8
 */

 /*
  * Brute Force: 
    * 1. Take the number A and convert it to string.
    * 2. Reverse the string.
    * 3. For each character in the string, convert it to integer and multiply it
    *    with the base raised to the power of its index.
    * 4. Sum all the results to get the decimal value.

    * Time Complexity: O(log A) - because we are dividing the number by 10 in each iteration.
    * Space Complexity: O(1) - we are using a constant amount of space.
  */

public class AnyBaseToDecimal {
    public int solve(int A, int B) {
        int num = A;
        int result = 0;
        int multiplier = 1;
        // int powNum = 0;

        while (num > 0) {
            int rem = num % 10;
            num /= 10;
            result += multiplier * rem;
            multiplier *= B;
            // result += (rem*(int)Math.pow(B,powNum));
            // powNum++;
        }

        return result;
    }

    // Time complexity: O(log A)
    // Space complexity: O(1)

}
