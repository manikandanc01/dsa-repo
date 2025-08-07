/*
 * 
 * Problem Description

Given two binary strings A and B. Return their sum (also a binary string).


Problem Constraints

1 <= length of A <= 105

1 <= length of B <= 105

A and B are binary strings



Input Format

The two argument A and B are binary strings.



Output Format

Return a binary string denoting the sum of A and B



Example Input

Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"


Example Output

Output 1:
"111"
Output 2:
"1000"


Example Explanation

For Input 1:
The sum of 100 and 11 is 111.
For Input 2:
 
The sum of 110 and 10 is 1000.
 */

package Scaler.Intermediate.Strings;

public class AddBinaryStrings {

    public String addBinary(String A, String B) {
        // Brute force is convert the string to number, by using the given binary digits
        // add 2 numbers
        // convert the result to binary digits
        // Since string length will be huge, so we can't able to convert the string to a
        // number. It will overflow

        // Because of string concatenation it will be having some overhead
        // Instead we can use char array or String Builder

        int nA, nB;
        char res[];
        int i, j, k;
        nA = A.length();
        nB = B.length();
        res = new char[Math.max(nA, nB) + 1];
        k = Math.max(nA, nB);
        i = nA - 1;
        j = nB - 1;
        int sum = 0, carry = 0;
        // we add bits from the rightmost bit to the leftmost bit
        while (i >= 0 || j >= 0 || carry != 0) {
            sum = carry;
            if (i >= 0)
                sum += (A.charAt(i) - '0');
            if (j >= 0)
                sum += (B.charAt(j) - '0');
            res[k] = (char) ((sum % 2) + '0');
            carry = sum / 2;
            i--;
            j--;
            k--;
        }
        if (res[0] == '1')
            return new String(res);
        int len = Math.max(nA, nB);
        return new String(res, 1, len); // new String(String, startIndex, length)

        // Better approach: Add the digits from the last of the 2 strings.
        // Tc is O(max(n.m)), Sc is O(1)

        // int n = A.length();
        // int m = B.length();

        // int carry = 0;
        // String res = "";

        // int i = n-1;
        // int j = m-1;

        // while(i>=0 && j>=0){
        // int sum = (A.charAt(i)-'0') + (B.charAt(j)-'0')+carry;
        // int rem = sum%2;
        // carry = sum/2;

        // res = (char)(rem+'0')+res;

        // i--;
        // j--;
        // }

        // while(i>=0){
        // int sum = (A.charAt(i)-'0')+carry;
        // int rem = sum%2;
        // carry = sum/2;

        // res = (char)(rem+'0')+res;

        // i--;
        // }

        // while(j>=0){
        // int sum = (B.charAt(j)-'0')+carry;
        // int rem = sum%2;
        // carry = sum/2;

        // res = (char)(rem+'0')+res;

        // j--;
        // }

        // if(carry != 0){
        // res = (char)(carry+'0')+res;
        // }

        // return res;
    }

}
