class Solution {
    
    private String s;
    private int len;
    private int[] cache;
    
    public int numDecodings(String s) {
        this.s = s;
        len = s.length();
        
        cache = new int[len];
        for(int i=0;i<len;i++) {
            if(s.charAt(i) == '0') cache[i] = 0;
            else cache[i] = -1;
        }
            
        
        return recur(0);
    }
    
    private int recur(int idx) {
        if(idx == len) {
            return 1;
        }
        
        if(cache[idx] != -1) return cache[idx];
        
        char cur = s.charAt(idx);
        
        // 1 ~ 9 사용
        int ans =recur(idx+1);
        
        // 10 ~ 19 사용
        if(cur == '1' && idx < len -1) ans += recur(idx+2);
        
        // 20 ~ 26
        if(cur == '2' && idx < len -1 && s.charAt(idx+1) <= '6') ans += recur(idx+2);
        
        return cache[idx] = ans;
    }
}