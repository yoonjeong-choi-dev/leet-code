class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        
        int left = 0, right = 0;
        int curZero = 0;
        int ans = 0;
        
        while(right < len) {
            if(nums[right++] == 0) curZero++;
            
            while(curZero > k) {
                if(nums[left++] == 0) curZero--;
            }
            
            ans = Math.max(ans, right-left);
        }
        return ans;
    }
}