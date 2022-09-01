class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        
        // (sum, index) : sum = sum(nums[:index])
        Map<Integer, Integer> prefixIndex = new HashMap<>();
        
        int curSum = 0, diff;
        for(int i=0;i<nums.length;i++){
            curSum += nums[i];
            
            if(curSum == k) ans = Math.max(ans, i+1);
            else {
                // sum(nums[x+1:i]) = partial[i] - partial[x] = curSum - partial[x] = k 
                // <=> curSum - k = partial[x];
                diff = curSum - k;
                if(prefixIndex.containsKey(diff)) {
                    ans = Math.max(ans, i - prefixIndex.get(diff));
                }
            }
            
            // update prefix
            if(!prefixIndex.containsKey(curSum)) prefixIndex.put(curSum, i);
        }
        
        return ans;
    }
}