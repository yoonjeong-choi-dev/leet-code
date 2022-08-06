class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        Set<Character> set = new HashSet<>();
        
        int ans = 1;
        int left=0, right=0;
        char cur;
        
        while(right < len) {
            // add right char
            cur = s.charAt(right++);
            
            while(set.contains(cur)) {
                set.remove(s.charAt(left++));
            }
            set.add(cur);
            ans = Math.max(ans, right - left);
            
        }
        return ans;
    }
}