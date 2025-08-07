/*
 * Problem Description

You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.

Problem Constraints

1 <= N <= 105
A and B are lowercase strings


Input Format
Both arguments A and B are a string.

Output Format
Return 1 if they are anagrams and 0 if not


Example Input
Input 1:
A = "cat"
B = "bat"
Input 2:
A = "secure"
B = "rescue"

Example Output
Output 1:
0
Output 2:
1


Example Explanation

For Input 1:
The words cannot be rearranged to form the same word. So, they are not anagrams.
For Input 2:
They are an anagram.
 */

package Scaler.Intermediate.Strings;

public class CheckAnagrams {
    public int solve(String A, String B) {
        // Better approach:
        // Given letters are lowercase english letters
        // Tc is: O(n), Sc is O(1)

        int n = A.length();
        int m = B.length();

        if (n != m) {
            return 0;
        }

        int[] freqOfStringA = new int[26];
        int[] freqOfStringB = new int[26];

        for (int i = 0; i < n; i++) {
            freqOfStringA[A.charAt(i) - 'a']++;
            freqOfStringB[B.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqOfStringA[i] != freqOfStringB[i]) {
                return 0;
            }
        }

        return 1;

        // Check anagrams
        // Brute force: Sort both the strings and compare each character
        // Tc is: O(n log n), Sc is O(n)

        // int n = A.length();
        // int m = B.length();

        // if(n!=m){
        // return 0;
        // }

        // char[] str1 = A.toCharArray();
        // char[] str2 = B.toCharArray();

        // Arrays.sort(str1);
        // Arrays.sort(str2);

        // for(int i=0; i<n; i++){
        // if(str1[i] != str2[i]){
        // return 0;
        // }
        // }

        // return 1;
    }

}
