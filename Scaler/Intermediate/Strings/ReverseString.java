package Scaler.Intermediate.Strings;

public class ReverseString {
    public String solve(String A) {

        // We can also use stack to solve this problem

        // using library methods of string
        // Tc is O(n), Sc is O(n)
        // String[] str = A.trim().split(" ");

        // StringBuilder res = new StringBuilder();
        // int n = str.length;
        // for(int i=n-1; i>=0; i--){
        // res.append(str[i]);
        // if(i!=0){
        // res.append(" ");
        // }
        // }

        // return res.toString();

        // Brute force
        // Iterate the string from reverse
        // Tc is O(n), Sc is O(n)

        int n = A.length();
        char[] str = A.toCharArray();
        StringBuilder res = new StringBuilder();
        int i = n - 1;
        while (i >= 0) {
            while (i >= 0 && str[i] == ' ') {
                i--;
            }

            // Can optimize string concatenation
            // by using StringBuilder
            StringBuilder temp = new StringBuilder();
            while (i >= 0 && str[i] != ' ') {
                temp.append(str[i]);
                i--;
            }
            res.append(temp.reverse().toString() + " ");
            // String temp = "";
            // while (i >= 0 && str[i] != ' ') {
            // temp = (str[i] + temp);
            // i--;
            // }

            // res.append(temp + " ");
        }

        return res.toString().trim();

    }

}
