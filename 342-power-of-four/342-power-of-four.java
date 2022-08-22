class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        
        int exp = 0;
        while (n != 1) {
            exp++;
            if (n % 2 == 1) return false;
            n /= 2;
        }

        return exp % 2 == 0;
    }
}