public class UnsetBit {
    public int solve(int A, int B) {
        return ((1<<B)&A)==0?A:(A^(1<<B));
    }
}
