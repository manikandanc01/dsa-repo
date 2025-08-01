/*
 * Problem Description

Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints

1 <= |A| <= 105

String A consist only of lowercase characters.



Input Format

First and only argument is a string A.



Output Format

Return a string denoting the reversed string.



Example Input

Input 1:

 A = "scaler"
Input 2:

 A = "academy"


Example Output

Output 1:

 "relacs"
Output 2:

 "ymedaca"


Example Explanation

Explanation 1:

 Reverse the given string.
 */

package Scaler.Intermediate.Strings;

public class SimpleReverse {
    public String solve(String A) {
        // another way is iterate half way through and swap

        int n = A.length();
        char[] str = A.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = str[i];
            str[i] = str[n - i - 1];
            str[n - i - 1] = temp;
        }
        return new String(str);
        // Tc is O(n), Sc is O(n)
        // int n = A.length();
        // char[] arr = new char[n];
        // int idx = 0;
        // for (int i = n - 1; i >= 0; i--) {
        // arr[idx++] = A.charAt(i);
        // }

        // return new String(arr);

        // Brute force is using normal string concatenation
        // It will take long time.
        // Everytime new string will be created and append the character to the end of
        // the string
        // Leads to time complexity: O(n^2), Sc O(1)
        // String res = "";

        // for(int i=n-1; i>=0; i--){
        // res += A.charAt(i);
        // }

        // return res;
    }

}
