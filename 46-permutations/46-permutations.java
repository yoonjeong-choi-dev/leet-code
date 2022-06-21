class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    private int len;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        len = nums.length;
        
        ans = new ArrayList<>();
        
        // order[i] : i 번째 위치의 nums 인덱스
        int[] order = new int[len];        
        Arrays.fill(order, -1);
        
        recur(0, order);
        return ans;
    }
    
    private void recur(int curIdx, int[] order) {
        if(curIdx == len) {
            List<Integer> curAns = new ArrayList();
            for(int i : order) curAns.add(nums[i]);
            
            ans.add(curAns);
            return;
        }
        
        for(int i=0;i<len;i++){
            if(order[i] == -1) {
                order[i] = curIdx;
                recur(curIdx+1, order);
                order[i] = -1;
            }
        }
    }
}