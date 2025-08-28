import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColourfulNumber {
     public int colorful(int A) {
        // Brute Force:
        // first generate an array of digits
        // for(i=0 -> n)
        //   for(j=i -> n)
        //       product = 1
        //       for(k=i -> j)
        //             product *= k
        //        check if the product is there in the list, if yes return 0, else return 1;
        //        add the product to the list.
        // Tc will be O(k*k*k), Sc is O(k), k is (log base 10 A)


        // Optimized approach: Instead of building product from scratch, use rolling product.
        // And Instead of List to check the product already exists or not use HashSet to check that in O(1)
        // Tc is O(k*k), Sc is O(k)

        ArrayList<Integer> arr = new ArrayList<>();
        while(A>0){
            int r = A%10;
            A/=10;
            arr.add(r);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.size(); i++){
            int product = 1;
            for(int j=i; j<arr.size(); j++){
                product *= arr.get(j);
                if(set.contains(product)){
                    return 0;
                } 
                set.add(product);
            }
        }

        return 1;
    }
}
