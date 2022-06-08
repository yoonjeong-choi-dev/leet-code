class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        final int NULL_VAL = len + 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) nums[i] = NULL_VAL;
        }

        int curVal;
        for (int i = 0; i < len; i++) {
            curVal = Math.abs(nums[i]);
            if (curVal == NULL_VAL) continue;
            if (nums[curVal - 1] > 0) nums[curVal - 1] = -nums[curVal - 1];
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) return i+1;
        }

        return len + 1;
    }
}