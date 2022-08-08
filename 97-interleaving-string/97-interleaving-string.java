class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 + len2 != s3.length()) return false;
        
        // dp[i][j] : isInterleave(s1.subString(i), s2.subString(j), s3.subString(i+j)) 
        boolean[][] dp = new boolean[len1+1][len2+1];
        
        for(int idx1 = 0;idx1<=len1;idx1++) {
            for(int idx2=0;idx2<=len2;idx2++) {
                int idx3 = idx1+idx2-1;
                
                if(idx1 == 0 && idx2 == 0) {
                    // base answer
                    dp[idx1][idx2] = true;
                } else if (idx1 == 0) {
                    // s2 -> s3
                    dp[idx1][idx2] = dp[idx1][idx2-1] && s2.charAt(idx2-1) == s3.charAt(idx3);
                } else if(idx2 == 0) {
                    // s1 -> s3
                    dp[idx1][idx2] = dp[idx1-1][idx2] && s1.charAt(idx1-1) == s3.charAt(idx3);
                } else {
                    dp[idx1][idx2] = (dp[idx1][idx2-1] && s2.charAt(idx2-1) == s3.charAt(idx3))
                        || (dp[idx1-1][idx2] && s1.charAt(idx1-1) == s3.charAt(idx3));
                }   
            }
        }
        
        return dp[len1][len2];
    }
}