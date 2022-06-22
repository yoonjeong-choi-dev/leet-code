class Solution {
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2)
        if(n<2) return 1;
        
        int prev = 1, cur = 1, temp;
        for(int i=2;i<=n;i++){
            temp = prev + cur;
            prev = cur;
            cur = temp;
        }
        
        return cur;
    }
}