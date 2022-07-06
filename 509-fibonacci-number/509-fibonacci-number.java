class Solution {
    public int fib(int n) {
        if(n<2) return n;
        
        int f_1 = 0, f_0 = 1, temp;
        
        for(int i=2;i<=n;i++){
            temp = f_1 + f_0;
            f_1 = f_0;
            f_0 = temp;
        }
        
        return f_0;
    }
}