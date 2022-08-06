class Solution {
    
    private List<List<Integer>> ans;
    private int[] nums;
    private int len;
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        this.nums = nums;
        len = nums.length;
        
        boolean[] path = new boolean[len];
        
        recur(0, path);
        return ans;
    }
    
    private void recur(int idx, boolean[] path) {
        if(idx == len) {
            List<Integer> curAns = new ArrayList<>();
            for(int i = 0;i<len;i++) 
                if(path[i]) curAns.add(nums[i]);
            ans.add(curAns);
            return;
        }
        
        path[idx] = true;
        recur(idx+1, path);
        path[idx] = false;
        recur(idx+1, path);
    }
}