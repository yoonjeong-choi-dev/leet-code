class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int curSum = 0, start=0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int end=0;end<len;end++){
            curSum += nums[end];
            
            while(curSum >= target) {
                ans = Math.min(ans, end - start + 1);
                curSum -= nums[start++];
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}