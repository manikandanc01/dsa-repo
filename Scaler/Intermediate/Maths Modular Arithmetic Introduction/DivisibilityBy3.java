import java.util.ArrayList;

public class DivisibilityBy3 {
    public int solve(ArrayList<Integer> A) {
        // Brute force is build an entire number and then take a mod and return
        // Integer overflow, and time limit will exceed if we build the entire number.

        // Optimized approach based on the property.
        // Tc is O(n), Sc is O(1)
        int n = A.size();
        // sum of the digits divisible by 3, the whole number will be divisible by 3
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int value = A.get(i);
            sum = (sum + value) % 3;
        }

        return (sum % 3 == 0) ? 1 : 0;
    }

}
