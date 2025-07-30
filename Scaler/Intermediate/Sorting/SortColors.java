package Scaler.Intermediate.Sorting;

import java.util.ArrayList;

public class SortColors {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        // Brute force: only 0,1,2 will be there in the Array
        // So count each elements, and insert 0,1,2 to its respective count times
        // Tc: O(n) + O(n), Sc is O(1)

        // Optimized approach: One pass solution, using swaping logic
        // Pointer for zero in the beginnin of the array,
        // Pointer for two in the end of the array.
        // All the zeros should come to start of the array.
        // All the 2's should go to the end of the array.
        // And one will be in correct position, if we corrected the other two.
        // Tc is O(n), Sc is O(1)

        int n = A.size();
        int zeroPtr = 0;
        int twoPtr = n - 1;
        int i = 0;

        while (i <= twoPtr) {
            if (A.get(i) == 0) {
                int temp = A.get(zeroPtr);
                A.set(zeroPtr, A.get(i));
                A.set(i, temp);
                zeroPtr++;
                i++;
            } else if (A.get(i) == 2) {
                int temp = A.get(twoPtr);
                A.set(twoPtr, A.get(i));
                A.set(i, temp);
                twoPtr--;
            } else {
                i++;
            }
        }

        return A;
        // int zeroCount = 0;
        // int oneCount = 0;
        // int twoCount = 0;

        // for(int num : A){
        // if(num == 0){
        // zeroCount++;
        // }else if(num == 1){
        // oneCount++;
        // }else{
        // twoCount++;
        // }
        // }

        // ArrayList<Integer> result = new ArrayList<>();
        // insertElements(zeroCount, 0, result);
        // insertElements(oneCount, 1, result);
        // insertElements(twoCount, 2, result);

        // return result;
    }

    public void insertElements(int count, int element, ArrayList<Integer> arr) {
        for (int i = 0; i < count; i++) {
            arr.add(element);
        }
    }

}
