public class UnsetXBitsFromRight {
    public long solve(long A, int B) {
        // for (int i = 0; i < B; i++) {
        //     if ((A & (1 << i)) != 0) {
        //         A = (A - (1 << i));
        //     }
        // }

        // return A;
        // Tc is O(B), and Sc is O(1)

        // We want rightmost B bits should be unset
        // Let's left shift the one B times
        // And subtract 1 from that, result in Bth bit to be Unset and B-1 bit to be set
        // Take complement ->  Set B-1 bits to be unset
        // Now take the and. 

        return A&(~((1<<B)-1));
    }  

}
