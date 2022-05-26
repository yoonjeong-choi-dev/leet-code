public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;

        // n : ***10...0 => n-1 : ***01...1
        // => n & n-1 == ***00...0
        // *** 에 대해서만 생각하면 된다
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }

        return ans;
    }
}