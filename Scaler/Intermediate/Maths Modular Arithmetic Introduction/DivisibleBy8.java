public class DivisibleBy8 {
    public int solve(String A) {
        // Brute force: Build the number from the String
        // Using ten powers: and find the mod at each level. It will take Tc O(n) and Sc
        // as O(1)

        // Optimized approach: using the property, if the last 3 digits divisible by 8
        // and the entire number
        // divisible by 8

        int num = 0;
        int tenPwr = 1;
        int n = A.length();

        int count = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (count > 3) {
                break;
            }
            int value = A.charAt(i) - '0'; // char to integer conversion
            num += value * tenPwr;
            tenPwr *= 10;
            count++;
        }

        return num % 8 == 0 ? 1 : 0;
    }
}
