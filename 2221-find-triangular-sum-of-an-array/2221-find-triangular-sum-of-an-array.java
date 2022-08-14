class Solution {
    public int triangularSum(int[] nums) {
        for (int len = nums.length - 1; len > 0; len--) {
            for (int i = 0; i < len; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        
        return nums[0];
    }
}