class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        int startIdx = 0;
        int ans = 0;
        
        int curLen, endIdx;
        while(startIdx < len) {
            // startIdx 에서 시작하는 연속 배열 찾기 :[startIdx, endIdx)
            endIdx = startIdx+1;
            while(endIdx < len && (nums[endIdx] == nums[endIdx-1] + 1 || nums[endIdx] == nums[endIdx-1])) endIdx++;
            
            ans = Math.max(ans, nums[endIdx-1] - nums[startIdx]+1);
            startIdx = endIdx;
        }
        
        return ans;
    }
}