class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;

        Map<Character, Integer> charIndex = new HashMap<>();
        
        int ans = 1;
        int left=0, right=0;
        char cur;
        
        while(right < len) {
            // add right char
            cur = s.charAt(right);
            
            if(charIndex.containsKey(cur)) {
                left = Math.max(left, charIndex.get(cur) + 1);
            }
            
            ans = Math.max(ans, right - left+1);
            charIndex.put(cur, right++);
            
        }
        return ans;
    }
}