class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        
        int len = nums.length;
        int left = 0, right = len-1, mid;
        
        // start position
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                ans[0] = mid;
                right = mid -1;
            } else if(nums[mid] < target) left = mid + 1;
            else right = mid -1;
        }
        
        if(ans[0] == -1) return ans;
        
        left = ans[0];
        right = len-1;
        while(left <= right){
            mid = left + (right - left )/2;
            if(nums[mid] == target){
                ans[1] = mid;
                left = mid+1;
            } else if(nums[mid] < target) left = mid + 1;
            else right = mid -1;
        }
        
        if(ans[1] == -1) ans[1] = ans[0];
        return ans;
    }
}