public class HelpFromSam {
    public int solve(int A) {
        // count of set bits
        // Intuit from reverse
        // A=10, if A is even divide by 2
        // else if A is odd, subtract 1 and increment the helpFromSam 1
        // do this till A becomes 0.
        // Time complexity is O(log A) and space complexity is O(1)
        // This is the same as counting the number of set bits in A

        int result = 0;
        int idx = 0;
        while ((1 << idx) <= A) {
            if ((A & (1 << idx)) > 0) {
                result += 1;
            }
            idx++;
        }

        return result;
    }

}
