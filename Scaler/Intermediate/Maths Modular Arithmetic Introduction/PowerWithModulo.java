public class PowerWithModulo {
    public int solve(int A, int B, int C) {
        long ans = 1;
        for (int i = 0; i < B; i++) {
            ans = (ans % C * (A % C)) % C;
        }

        return (int) ans;

        // Tc is O(B), Sc is O(1)
    }
}