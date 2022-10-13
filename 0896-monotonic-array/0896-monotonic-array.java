class Solution {
    public boolean isMonotonic(int[] nums) {
        return isInc(nums) || isDec(nums);
    }
    
    private boolean isInc(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] > nums[i]) return false;
        }
        return true;
    }
    
    private boolean isDec(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] < nums[i]) return false;
        }
        return true;
    }
}