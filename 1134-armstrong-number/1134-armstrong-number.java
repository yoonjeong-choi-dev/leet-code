class Solution {
    public boolean isArmstrong(int n) {
        int temp = n;
        int numDigits = 0;
        while (temp != 0) {
            numDigits++;
            temp /= 10;
        }

        temp = n;
        int sum = 0;
        while (temp != 0) {
            sum += Math.pow(temp % 10, numDigits);
            temp /= 10;
            
            // early escape for overflow
            if (sum > n) return false;
        }

        return sum == n;
    }
}