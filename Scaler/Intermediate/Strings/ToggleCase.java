/*
 * Problem Description

You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.

You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.



Problem Constraints

1 <= N <= 105

A[i] ∈ ['a'-'z', 'A'-'Z']



Input Format

First and only argument is a character string A.



Output Format

Return a character string.



Example Input

Input 1:

 A = "Hello" 
Input 2:

 A = "tHiSiSaStRiNg" 


Example Output

Output 1:

 hELLO 
Output 2:

 ThIsIsAsTrInG 
 */

package Scaler.Intermediate.Strings;

public class ToggleCase {
    public String solve(String A) {
        // Brute force is using actual String Literal
        // This is inefficient
        // Because String in java is immutable
        // So every time we cancatenate the character, it will create a new
        // String(ans+c);
        // So it will leads to O(1+2+3+.....+N) = > O(n^2) time complexity

        // String ans="";
        // int n = A.length();
        // for(int i=0;i<n;i++){
        // char c = A.charAt(i);
        // if(c>='a' && c<='z'){
        // char upperCase =(char)(c-'a'+'A');
        // ans+=upperCase;
        // }else if(c>='A' && c<='Z'){
        // char lowerCase =(char)(c+'a'-'A');
        // ans+=lowerCase;
        // }
        // }

        // return ans;

        // Better use StringBuilder or character array
        // char[] arr = A.toCharArray();
        // char[] res = new char[A.length()];
        // int n = A.length();
        // for(int i=0;i<n; i++){
        // char c = arr[i];
        // if(c>='a' && c<='z'){
        // char upperCase =(char)(c-'a'+'A');
        // res[i]=upperCase;
        // }else if(c>='A' && c<='Z'){
        // char lowerCase =(char)(c+'a'-'A');
        // res[i]=lowerCase;
        // }
        // }

        // return new String(res);

        // another way we can use StringBuilder
        StringBuilder res = new StringBuilder();
        int n = A.length();

        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c >= 'a' && c <= 'z') {
                char upperCase = (char) (c - 'a' + 'A');
                res.append(upperCase);
            } else if (c >= 'A' && c <= 'Z') {
                char lowerCase = (char) (c + 'a' - 'A');
                res.append(lowerCase);
            }
        }

        return res.toString();
    }

}
