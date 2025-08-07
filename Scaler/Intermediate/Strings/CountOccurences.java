/*
 * Problem Description

Find the number of occurrences of bob in string A consisting of lowercase English alphabets.



Problem Constraints

1 <= |A| <= 1000


Input Format

The first and only argument contains the string A, consisting of lowercase English alphabets.


Output Format

Return an integer containing the answer.


Example Input

Input 1:

  "abobc"
Input 2:

  "bobob"


Example Output

Output 1:

  1
Output 2:

  2


Example Explanation

Explanation 1:

  The only occurrence is at second position.
Explanation 2:

  Bob occures at first and third position.
 */

package Scaler.Intermediate.Strings;

public class CountOccurences {
    public int solve(String A) {
        // here the keyString is constant
        // we can check this in one pass.
        // Tc is O(n), Sc is O(1)

        int n = A.length();
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (A.charAt(i) != 'b') {
                continue;
            }

            if (A.charAt(i + 1) == 'o' && A.charAt(i + 2) == 'b') {
                count++;
            }
        }

        return count;

        // Brute force: Consider all substrings
        // count number of bob substrings
        // Tc is O(n^2), Sc is O(n)

        // int n = A.length();
        // String keyString = "bob";
        // int count = 0;

        // for(int i=0; i<n; i++){
        // for(int j=i; j<n; j++){
        // String currString = A.substring(i,j+1);
        // if(currString.equals(keyString)){
        // count++;
        // }
        // }
        // }

        // return count;
    }

}
