class Solution {
    public int characterReplacement(String s, int k) {
        // s consists of only uppercase English letters
        int[] occurs = new int[26];
        
        int ans = k;
        int len = s.length();
        int left = 0;
        for(int right=0; right<len;right++){
            // 현재 문자 추가
            occurs[s.charAt(right) - 'A']++;
            
            // 왼쪽 인덱스 이동
            while(right-left+1 - getMax(occurs) > k) {
                occurs[s.charAt(left++) - 'A']--;
            }
            
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
    
    private int getMax(int[] occurs) {
        int ret = occurs[0];
        for(int o : occurs) ret = Math.max(ret, o);
        return ret;
    }
}