class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        String prevAns = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        
        int idx = 0, len = prevAns.length(), count;
        char curDigit;
        
        while(idx < len) {
            curDigit = prevAns.charAt(idx);
            count = 0;
            
            while(idx < len && curDigit == prevAns.charAt(idx)) {
                idx++;
                count++;
            }
            
            ans.append(count).append(curDigit);
        }
        
        return ans.toString();
    
    }
}