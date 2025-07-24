import java.util.ArrayList;

public class ModArray {
    public int solve(ArrayList<Integer> A, int B) {

        // Brute Force: TLE
        // Tc is O(n*B), Sc is O(1)

        // Optimized approach: Tc is O(n), Sc is O(1)
        long ans = 0;
        // int pwr = 0;
        int n = A.size();
        long tenPowerValue = 1;

        for (int i = n - 1; i >= 0; i--) {
            int value = A.get(i);
            ans = (ans % B + (value % B * tenPowerValue) % B) % B;
            tenPowerValue = (tenPowerValue % B * 10 % B) % B;

            // ans = (ans%B + (value%B*powerWithMod(10, pwr,B))%B)%B;
            // System.out.println(ans);
            // pwr++;
        }

        return (int) ans;
    }

    public int powerWithMod(int A, int B, int mod) {
        long result = 1;
        for (int i = 0; i < B; i++) {
            result = (result * A) % mod;
        }

        return (int) result;
    }

}
