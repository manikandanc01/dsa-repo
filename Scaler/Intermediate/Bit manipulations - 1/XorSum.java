
/*
 * Problem Description

Given two integers A and B. Find the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.

where P ⊕ Q is the bitwise XOR operation of the two numbers P and Q.

Note: Bitwise XOR operator will return 1, if both bits are different. If bits are same, it will return 0.


Problem Constraints

1 <= A, B <= 109


Input Format

The first argument is a single integer A.
The second argument is a single integer B.


Output Format

Return the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.


Example Input

Input 1:-
A = 6
B = 12
Input 2:-
A = 4
B = 9


Example Output

Output 1:-
10
output 2:-
13


Example Explanation

Expanation 1:-
X ^ A + X ^ B = 10 when X = 4
Explanation 2:-
X ^ A + X ^ B = 13 when X = 0
 */

public class XorSum {
    public int solve(int A, int B) {
        // Brute force is try out all possible X that gives Xor Sum less.
        // from 1 to 10^9. (TLE)

        // Other approach: if the bit is set in A and in B, set the bit in x as well. If
        // the
        // bit is unset in A and B unset that bit in X as well. So we can reduce the
        // sum.

        // Tc is O(log B), Sc is O(1).

        // But one observation is: If both ith bits of A and B are equal X also
        // equal((1,1,(0,0)) to that bit. If it is not equal(1,0), means in the final
        // answer that bit definitely become 1.
        // This is simply A^B. Tc is O(1), Sc is O(1).

        /*
         * int multiplier = 1;
         * int X = 0;
         * int maxValue = Math.max(A,B);
         * int currentBit = 0;
         * 
         * while(multiplier <= maxValue){
         * int helper = 1<<currentBit;
         * int value1 = A&helper;
         * int value2 = B&helper;
         * if(value1 !=0 && value2 != 0){
         * X = X|helper;
         * }
         * multiplier *= 2;
         * currentBit += 1;
         * }
         * 
         * return (A^X)+(B^X);
         */

        return A ^ B;

    }

}
