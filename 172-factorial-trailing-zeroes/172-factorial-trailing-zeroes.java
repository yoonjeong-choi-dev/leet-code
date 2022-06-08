class Solution {
    public int trailingZeroes(int n) {
        // 2의 개수보다 5의 개수가 항상 많음
        // => 5의 배수들에 대해서만 탐색하면 됨
        int numFive = 0;

        for (int i = 5; i <= n; i += 5) {
            int num = i;
            while (num % 5 == 0) {
                numFive++;
                num /= 5;
            }
        }

        return numFive;
    }
}