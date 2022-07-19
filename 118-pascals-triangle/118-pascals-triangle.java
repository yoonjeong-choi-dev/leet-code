class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> prev, cur;
        
        // Init first row
        prev = new ArrayList<>();
        prev.add(1);
        ans.add(prev);
        
        for(int row=2;row<=numRows;row++){
            cur = new ArrayList<>(row);
            cur.add(1);
            for(int i=0;i<row-2;i++) cur.add(prev.get(i) + prev.get(i+1));
            cur.add(1);
            
            ans.add(cur);
            prev = cur;
        }
        
        return ans;
    }
}