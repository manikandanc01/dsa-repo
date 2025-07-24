import java.util.ArrayList;
import java.util.Collections;

public class NthMagicNumber {
    public int solve(int A) {

        // Optimized approach: We can notice some pattern in the series.
        // Binary (1,2,3,4,....) => 0001, 0010, 0011, 0100, 0101, 0110, 0111, 1000....
        // our series, 5^1, 5^2, (5^2+5^1), 5^3, (5^3+5^1), (5^3+5^2), (5^3+5^2+5^1),
        // 5^4....
        // Lets say A = 8, binary of 8 => 1000, 4th bit is set, our result will be 5^4
        // Lets say A = 7, binary of 7 => 0111, 3rd, 2nd,and 1st bit is set, our result
        // will be (5^3+5^2+5^1)
        // Tc is O(log A), Sc is O(1)

        int result = 0;
        int idx = 0;
        int pwr = 1;

        while((1<<idx) <= A){
        if(((1<<idx)&A) > 0){
        result += (int)Math.pow(5,pwr);
        }
        pwr++;
        idx++;
        }

        return result;

        // Brute Force Approach:
        // Our series are growing like this,
        // 5^1, 5^2, (5^2+5^1), 5^3, 5^3+5^1, 5^3+5^2, 5^3+5^1,5^2.....
        // if we notice, the number of elements we can generate after finding the exact
        // square grows like this
        // 1, 2, 4, 8,.....means if we create 5^4, we can generate 8 more combinations
        // of elements based on this
        // Our constraints (1<=A<=5000) means we need to generate atleast 5000 elements
        // to find the answer
        // (1+2+4+8.....) => this is in gp, r = 2, sum of gp = a(r^n-1)/(r-1),
        // lets say if we take n=10, sum=> 2^10 = 1024, we need 5000, 2^13 wil be around
        // 8000
        // so we can find the powers of 5 from [1,2,3,---13] from this we can generate
        // the rest of the elements
        // How to generate rest of the elements?
        // [5,5^2,5^3,5^4,5^5,.....5^13]
        // find the sum of each subsets and store in the array.
        // sort the array.
        // and finally we can return the query in O(1).
        // Tc for this approach will be O(A * log A) -> because of sorting
        // Generating subsets is constant, no matter what will be the A is

     /*    int[] fivePowers = new int[13];
        int pwr = 1;

        for (int i = 0; i < 13; i++) {
            fivePowers[i] = (int) Math.pow(5, pwr);
            pwr++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        generateSubSet(0, 0, 13, fivePowers, result);

        Collections.sort(result);
        // for(int i=0; i<20; i++){
        // System.out.println(result.get(i));
        // }
        int r = result.get(A);
        return r;
        */

    }

    public void generateSubSet(int idx, int sum, int n, int[] fivePowers, ArrayList<Integer> result) {
        // choose or not choose
        if (idx == n) {
            result.add(sum);
            return;
        }

        sum += fivePowers[idx];
        generateSubSet(idx + 1, sum, n, fivePowers, result);
        sum -= fivePowers[idx];
        generateSubSet(idx + 1, sum, n, fivePowers, result);
    }

}
