public class ReverseBits {
    public long reverse(long A) {
        // Brute force
        // Tc O(1), Sc O(1)

        int reverseIdx = 31;
        long result = 0;

        for (int i = 0; i < 32; i++) {
            if (((1 << i) & A) > 0) {
                result += (1L << reverseIdx);
            }
            reverseIdx--;
        }
        return result;

    }
}
