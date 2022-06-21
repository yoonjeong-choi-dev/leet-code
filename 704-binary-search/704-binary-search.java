class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid;
        
        while(left < right) {
            mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        
        // left == right
        return nums[left] == target ? left : -1;
    }
}