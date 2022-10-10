class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIdx = new HashMap<>();
        
        int remain;
        for(int i=0;i<nums.length;i++){
            remain = target - nums[i];
            if(valToIdx.containsKey(remain)) return new int[]{valToIdx.get(remain), i};
            
            valToIdx.put(nums[i], i);
        }
        
        return null;
    }
}