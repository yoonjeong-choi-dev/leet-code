class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        // Edge Case : no rotation
        if(nums[0] <= nums[len-1]) return nums[0];
        
        // Edge Case : max rotation
        if(nums[len-2] > nums[len-1]) return nums[len-1];
        
        int left = 1, right = len-2;
        int mid;
        
        // nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1]
        while(left < right) {
            mid = (left+right)/2;
            
            if(nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1]) return nums[mid];
            else if(nums[mid] > nums[0]) left = mid+1;
            else right = mid-1;
        }
        
    
        return nums[left];
    }
}