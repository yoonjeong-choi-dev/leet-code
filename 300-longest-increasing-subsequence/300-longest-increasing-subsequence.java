class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        
        // dp[i] : nums[0:i+1] answer
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        for(int end = 1;end < len;end++) {
            for(int last = 0;last<end;last++) {
                if(nums[last] < nums[end]) {
                    dp[end] = Math.max(dp[end], dp[last] + 1);
                }
            }
        }
        
        int ans = 1;
        for(int a : dp) ans = Math.max(a, ans);
        
        return ans;
    }
}