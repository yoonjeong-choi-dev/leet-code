class Solution {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long ans = 0L;

        int curMin, curMax;
        for (int start = 0; start < len; start++) {
            curMax = curMin = nums[start];

            for (int end = start; end < len; end++) {
                curMin = Math.min(curMin, nums[end]);
                curMax = Math.max(curMax, nums[end]);

                ans += (long) curMax - curMin;
            }
        }
        return ans;
    }
}