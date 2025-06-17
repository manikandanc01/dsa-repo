import java.util.ArrayList;

public class SumOfEvenIndexes {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        // Brute force: Using two loops: Tc is O(n^2), sc is O(1)

        // Optimized: Using Prefix sum. Tc is O(n), Sc is O(n)

        int n = A.size();
        int[] pfsum = new int[n];
        pfsum[0] = A.get(0);

        for (int i = 1; i < n; i++) {
            pfsum[i] = pfsum[i - 1];
            if (i % 2 == 0) {
                pfsum[i] += A.get(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            int sum = pfsum[end];
            if (start != 0) {
                sum -= pfsum[start - 1];
            }
            result.add(sum);
        }

        return result;
    }
}
