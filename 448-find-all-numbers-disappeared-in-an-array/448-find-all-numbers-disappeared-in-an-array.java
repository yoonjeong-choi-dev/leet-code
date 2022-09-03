class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        int curVal;
        for(int i=0;i<n;i++){
            curVal = Math.abs(nums[i])-1;
            
            // 숫자 x 가 존재 한다 => nums[x-1] < 0
            if(nums[curVal] > 0) nums[curVal] *= -1;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i] > 0) ans.add(i+1);
        }
        
        return ans;
    }
}