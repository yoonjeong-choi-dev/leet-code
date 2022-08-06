class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] : s.substring(i+1) 에 대한 부분 문제
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for(int end = 0;end<=len;end++){
            for(int start = 0; start<end;start++){
                if(dp[start] && wordSet.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}