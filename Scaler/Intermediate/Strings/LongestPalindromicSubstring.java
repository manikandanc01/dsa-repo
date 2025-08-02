/*
 * Problem Description

Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints

1 <= N <= 6000



Input Format

First and only argument is a string A.



Output Format

Return a string denoting the longest palindromic substring of string A.



Example Input

Input 1:
A = "aaaabaaa"
Input 2:
A = "abba


Example Output

Output 1:
"aaabaaa"
Output 2:
"abba"


Example Explanation

Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
 */

package Scaler.Intermediate.Strings;

public class LongestPalindromicSubstring {
    public String expandAroundCenter(int left, int right, int n, String str) {
        while (left >= 0 && right <= n - 1 && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring(left + 1, right);
    }

    public String longestPalindrome(String A) {
        int n = A.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            String oddString = expandAroundCenter(i, i, n, A);
            if (oddString.length() > longest.length()) {
                longest = oddString;
            }

            String evenString = expandAroundCenter(i, i + 1, n, A);
            if (evenString.length() > longest.length()) {
                longest = evenString;
            }
        }

        return longest;
        // Better approach
        // consider odd length palindrome: aabaa, except one midpoint all others should
        // be same.
        // so consider every element as the center and expand on both sides to check the
        // palindrome length.
        // for even length palindrome: ceabbaec, here center two letters will be same,
        // if i and i+1 are same, try to expand on both sides and calculate the length
        // Tc is O(n^2). and Sc is O(n). if we didn't convert the String to charArray,
        // Sc will be O(1).

        // int n = A.length();
        // char[] str = A.toCharArray();
        // int len = 1;
        // int start = 0;
        // int end = 0;

        // for (int i = 0; i < n; i++) {
        // for odd length palindrome: Consider current element as the centre element
        // and expand on both sides
        // int left = i - 1;
        // int right = i + 1;

        // while (left >= 0 && right < n && str[left] == str[right]) {
        // left--;
        // right++;
        // }

        // if ((right - left - 1) > len) {
        // len = right - left - 1;
        // start = left + 1;
        // end = right - 1;
        // }

        // consider even length pallindrome: consider i and i+1 as center points and
        // expand on both sides
        // if (i + 1 < n && str[i] == str[i + 1]) {
        // left = i - 1;
        // right = i + 2;

        // while (left >= 0 && right < n && str[left] == str[right]) {
        // left--;
        // right++;
        // }

        // if ((right - left - 1) > len) {
        // len = right - left - 1;
        // start = left + 1;
        // end = right - 1;
        // }
        // }

        // }

        // String res = "";
        // for (int i = start; i <= end; i++) {
        // res += str[i];
        // }

        // return A.substring(start, end + 1);

        // Brute force: Consider all valid substrings
        // Check for palindrome.
        // Tc is O(n^3), Sc is O(n)

        // int n = A.length();
        // char[] str = A.toCharArray();
        // int len = 1;
        // int start = 0;
        // int end = 0;

        // for(int i=0; i<n; i++){
        // for(int j=i; j<n; j++){
        // if(checkForPalindrome(i,j,str)){
        // if((j-i+1) > len){
        // len = j-i+1;
        // start = i;
        // end = j;
        // }
        // }
        // }
        // }

        // String res = "";
        // for(int i=start; i<=end; i++){
        // res+= str[i];
        // }

        // return res;
    }

    public boolean checkForPalindrome(int start, int end, char[] str) {
        while (start < end) {
            if (str[start] != str[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

}
