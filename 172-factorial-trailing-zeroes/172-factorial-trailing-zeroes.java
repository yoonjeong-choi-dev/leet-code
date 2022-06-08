class Solution {
    public int trailingZeroes(int n) {
        // n! 의 trailing zeroes == 소인수분해 시 2와 5의 개수
        int numTwo = 0, numFive = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num % 2 == 0) {
                numTwo++;
                num /= 2;
            }

            while (num % 5 == 0) {
                numFive++;
                num /= 5;
            }
        }

        return Math.min(numTwo, numFive);
    }
}