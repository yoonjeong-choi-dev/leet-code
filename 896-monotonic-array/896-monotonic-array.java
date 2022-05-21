class Solution {
    public boolean isMonotonic(int[] nums) {
        return isIncrease(nums) || isDecrease(nums);
    }

    private boolean isIncrease(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) return false;
        }
        
        return true;
    }

    private boolean isDecrease(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]) return false;
        }

        return true;
    }
}