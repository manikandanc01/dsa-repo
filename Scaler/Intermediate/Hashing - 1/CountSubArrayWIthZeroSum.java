import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWIthZeroSum {
    // Brute force: consider all subarrays, check if sum is zero
    // Tc is O(n^3), Sc is O(1)

    // Use prefix sum for find the sum in O(n^2)
    // Tc is O(n^2), Sc is O(1)

    // Use HashMap to store the prefix sum and its frequency
    // Tc is O(n), Sc is O(n)
     public int solve(ArrayList<Integer> A) {
        Map<Long,Long> freq = new HashMap<>();

        freq.put(0L,0L);
        int mod = 1000000007;
        Long count = 0L;
        Long sum = 0L;

        for(int num : A){
            sum += num;
            if(!freq.containsKey(sum)){
                freq.put(sum,1L);
            }else{
                if(sum == 0){
                    count += freq.get(sum)+1;
                }else{
                    count += freq.get(sum);
                }

                freq.put(sum,freq.get(sum)+1);
            }

        }

        return (int)(count%mod);
    }
    
}
