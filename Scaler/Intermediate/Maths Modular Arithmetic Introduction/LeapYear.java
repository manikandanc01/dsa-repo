public class LeapYear {
    public int solve(int A) {
        // Every 400 th year is a leap year and Every 100th year is a non-leap year
        // and year divide by 4 is a leap year
        if (A % 400 == 0) {
            return 1;
        }

        if (A % 100 == 0) {
            return 0;
        }

        if (A % 4 == 0) {
            return 1;
        }

        return 0;
        /*
         * if(A%4!=0){
         * return 0;
         * }
         * 
         * if(A%100 == 0){
         * if(A%400 == 0){
         * return 1;
         * }else{
         * return 0;
         * }
         * }
         * 
         * return 1;
         */
    }
}
