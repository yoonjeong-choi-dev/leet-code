class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 빠르게 단어를 찾기 위해 Set 자료구조 사용
        Set<String> dicts = new HashSet<>(wordDict);
        
        // dp[i] : s.substring(0,i)에 대한 부분 문제
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for(int end=1;end<=len;end++){
            for(int start=0;start<end;start++){
                // s.substring(start, end) 존재 및 s.substring(0, start) 부분 문제가 참인 경우
                // => s.substring(0, end) 참
                if(dp[start] && dicts.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}