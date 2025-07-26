/*
 * 
 * Problem Description

Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints

1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format

The first argument is an array of integers.



Output Format

Return a string representing the largest number.



Example Input

Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output

Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation

Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */

package Scaler.Intermediate.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class LargestNumber {
    public String largestNumber(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A, (a, b) -> {
            String str1 = toString(a);
            String str2 = toString(b);

            long num1 = toNum(str1 + str2);
            long num2 = toNum(str2 + str1);

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }

            return 0;
        });

        if (A.get(0) == 0) {
            return "0";
        }
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            res += toString(A.get(i));
        }

        return res;

        // int n = A.size();
        // ArrayList<String> str = new ArrayList<>();
        // for(int i=0; i<n; i++){
        // String s = toString(A.get(i));
        // if(s.length() == 0){
        // continue;
        // }
        // str.add(s);
        // // System.out.println(str[i]);
        // }

        // if(str.size() == 0){
        // return "0";
        // }

        // Collections.sort(str, (a,b)->{
        // // String comb1 = a+b;
        // // String comb2 = b+a;

        // // long num1 = toNum(comb1);
        // // long num2 = toNum(comb2);

        // // return (int)(num1-num2);
        // return (a+b).compareTo(b+a);
        // });

        // String res = "";
        // for(int i=n-1; i>=0; i--){
        // res += str.get(i);
        // // System.out.println(str.get(i));
        // }

        // return res;
    }

    public long toNum(String str) {
        long tenPwr = 1;
        long result = 0L;
        for (int i = str.length() - 1; i >= 0; i--) {
            result += (long) (str.charAt(i) - '0') * tenPwr;
            tenPwr *= 10;
        }

        return result;
    }

    public String toString(int num) {
        String result = "";
        while (num > 0) {
            char rem = (char) (num % 10 + '0');
            result = (rem + result);
            num /= 10;
        }

        return result;
    }

}
