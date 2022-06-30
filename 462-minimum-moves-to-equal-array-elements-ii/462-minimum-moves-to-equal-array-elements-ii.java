class Solution {
    public int minMoves2(int[] nums) {
        // 모든 요소를 median로 만든다
        Arrays.sort(nums);
        
        int median = nums[nums.length/2];
        int ans = 0;
        for(int num : nums) ans += Math.abs(median - num);
        
        return ans;
    }
}