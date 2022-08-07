class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        
        int len = s.length();
        
        Map<Character, Integer> counter = new HashMap<>();
        
        int left = 0, right = 0, prevCount;
        char cur, prev;
        
        int ans = 1;
        while(right < len) {
            cur = s.charAt(right++);
            counter.put(cur, counter.getOrDefault(cur, 0) + 1);
            
            while(counter.size() > k) {
                prev = s.charAt(left++);
                prevCount = counter.get(prev);
                if(prevCount == 1) {
                    counter.remove(prev);
                } else {
                    counter.put(prev, prevCount-1);
                }
            }
            
            ans = Math.max(ans, right - left);
        }
        
        return ans;
    }
}