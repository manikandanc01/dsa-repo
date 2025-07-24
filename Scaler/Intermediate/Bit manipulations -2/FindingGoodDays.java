public class FindingGoodDays {
    public int solve(int A) {
        // this is nothing but the count of ones in the binary of the number
        // same to the previous problem
        // Tc is O(log A), sc is O(1)

        // int result = 0;
        // while(A>0){
        // if(A%2 !=0){
        // A=A-1;
        // result++;
        // }else{
        // A/=2;
        // }
        // }

        // return result;

        // Use bitwise operator

        // int idx = 0;
        // int result = 0;
        // while((1<<idx) <= A){
        // if((A&(1<<idx)) > 0){
        // result++;
        // }
        // idx++;
        // }

        // return result;

        // Another approach
        // use this logic A-1 -> set the first rightmost set bit to 0, and all other
        // right bits to 1
        // and keeps the same after that first set bit
        // eg: A=10100, A-1 => 10011, A&A-1 => 10000 -> so it unset the first set bit
        // from right.
        // till the A becomes 0 we can continue this approach

        int result = 0;
        while (A > 0) {
            A = A & (A - 1);
            result++;
        }

        return result;

        // Tc is O(number of set bits)

    }
}
