/*
 * Problem Description

Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.


The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".




Problem Constraints

0 <= sum of length of all strings <= 1000000



Input Format

The only argument given is an array of strings A.



Output Format

Return the longest common prefix of all strings in A.



Example Input

Input 1:


A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];






Example Output

Output 1:

"a"
Output 2:

"ab"


Example Explanation

Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
 */

package Scaler.Intermediate.Strings;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        // Brute force:
        // I just check for each index, the char is same in all the Strings in A or not.
        // let's say min length of all the string is k, Tc is O(n*k), Sc is O(k)

        // for each index i, I check if all the strings have same char at index i.

        // and little bit cleaner approach
        String ans = "";
        int n = A.size();

        if (n == 0) {
            return ans;
        }

        int length = A.get(0).length();
        for (int i = 0; i < length; i++) {
            // char currChar = ' ';
            // int flag = 0;
            char currChar = A.get(0).charAt(i);
            // for(int j=0; j<n; j++){
            // String currStr = A.get(j);
            // if(currStr.length() <= i){
            // flag = 1;
            // break;
            // }

            // if(currChar==' '){
            // currChar = A.get(j).charAt(i);
            // }else if(currChar != A.get(j).charAt(i)){
            // flag = 1;
            // break;
            // }

            // }

            for (int j = 1; j < n; j++) {
                if (A.get(j).length() <= i || A.get(j).charAt(i) != currChar) {
                    return ans;
                }
            }

            ans += A.get(0).charAt(i);

            // if(flag == 0){
            // ans+=A.get(0).charAt(i);
            // }else{
            // break;
            // }
        }

        return ans;
    }

}
