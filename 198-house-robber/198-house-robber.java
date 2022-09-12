class Solution {
    public int rob(int[] nums) {
        int numHouse = nums.length;
        
        if(numHouse == 1) return nums[0];
        
        int[] dp = new int[numHouse];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        int ans = Math.max(dp[0], dp[1]);
        
        for(int i=2;i<numHouse;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            ans = Math.max(ans, dp[i]);
        }
            
        return ans;
    }
}