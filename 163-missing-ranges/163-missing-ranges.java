class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0) {
            ans.add(generateInterval(lower, upper));
            return ans;
        }
        
        if(nums[0] != lower) ans.add(generateInterval(lower, nums[0]-1));
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] +1 == nums[i+1]) continue;
            ans.add(generateInterval(nums[i]+1, nums[i+1]-1));
        }
        
        if(nums[nums.length-1] != upper) ans.add(generateInterval(nums[nums.length-1]+1, upper));
        return ans;
    }
    
    private String generateInterval(int from, int to) {
        if(from == to) return String.valueOf(from);
        else return String.format("%d->%d", from, to);
    }
}