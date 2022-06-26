class Solution {
    public int rob(int[] nums) {
        int numHouse = nums.length;
        
        // Assumption : numHouse > 1
        if(numHouse == 1) return nums[0];
        
        // [0,i] 구간까지 부분 정답
        int[] dp = new int[numHouse];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        int ans = Math.max(dp[0], dp[1]);
        
        for(int i=2;i<numHouse;i++){
            // i번째 집 훔칠지 말지 결정
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}