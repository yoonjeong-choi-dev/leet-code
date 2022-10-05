class Solution {
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2)
        // f(1) == 1, f(2) = 2
        if(n<=2) return n;
        
        int f_1 = 2, f_2 = 1, temp;
        
        for(int i=3;i<=n;i++){
            temp = f_1;
            f_1 = f_1 + f_2;
            f_2 = temp;
        }
        return f_1;
    }
}