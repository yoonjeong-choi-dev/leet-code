class Solution {
    private int ans, target, len;
    private int[] nums;
    
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        this.nums = nums;
        this.len = nums.length;
        this.target = target;

        recursive(0, 0);
        return ans;
    }
    
    private void recursive(int idx, int curSum) {
        if (idx == len) {
            if (curSum == target) ans++;
            return;
        }

        recursive(idx + 1, curSum + nums[idx]);
        recursive(idx + 1, curSum - nums[idx]);
    }
}