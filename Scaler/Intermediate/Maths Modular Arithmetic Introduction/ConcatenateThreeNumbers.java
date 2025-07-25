/*
 * Problem Description
 * 
 * Given three 2-digit integers, A, B, and C, find out the minimum number
 * obtained by concatenating them in any order.
 * 
 * Return the minimum result obtained.
 * 
 * 
 * 
 * Problem Constraints
 * 
 * 10 <= A, B, C <= 99
 * 
 * 
 * 
 * Input Format
 * 
 * The first argument of input contains an integer, A.
 * 
 * The second argument of input contains an integer, B.
 * 
 * The third argument of input contains an integer, C.
 * 
 * 
 * 
 * Output Format
 * 
 * Return an integer representing the answer.
 * 
 * 
 * 
 * Example Input
 * 
 * Input 1:
 * 
 * A = 10
 * B = 20
 * C = 30
 * Input 2:
 * 
 * A = 55
 * B = 43
 * C = 47
 * 
 * 
 * Example Output
 * 
 * Output 1:
 * 
 * 102030
 * Output 2:
 * 
 * 434755
 * 
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * 
 * 10 + 20 + 30 = 102030
 * Explanation 2:
 * 
 * 43 + 47 + 55 = 434755
 */

import java.util.Arrays;

public class ConcatenateThreeNumbers {
    public int solve(int A, int B, int C) {
        // Brute force:Try out all the combinations
        // and return the minimum value.

        // here only 2 digit number
        // so we combine them in sorted order

        // Here timecomplexity O(1) for the given constriants
        // space complexity also constants.
        // This will work only for the numbers with the same length.
        // int[] arr = new int[3];
        // arr[0] = A;
        // arr[1] = B;
        // arr[2] = C;

        // Arrays.sort(arr);
        // int num = 0;
        // String res = "";
        // for(int i=0;i<3;i++){
        // res+=toString(arr[i]);
        // }

        // return toNum(res);

        // even easier way
        int[] arr = { A, B, C };
        Arrays.sort(arr);
        return arr[0] * 10000 + arr[1] * 100 + arr[2];
    }

    public int toNum(String A) {
        int tenPower = 1;
        int res = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int value = A.charAt(i) - '0';
            res += value * tenPower;
            tenPower *= 10;
        }

        return res;
    }

    public String toString(int num) {
        String res = "";
        while (num > 0) {
            int rem = num % 10;
            char c = (char) (rem + '0');
            res = (c + res);
            num /= 10;
        }

        return res;
    }
}
