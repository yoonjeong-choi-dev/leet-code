class Solution {
    
    private static final int[][] dirs = {{0,1},{0,-1}, {1,0},{-1,0}};
    
    private int[][] heights, map;
    private int rowSize, colSize;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rowSize = heights.length;
        colSize = heights[0].length;
        map = new int[rowSize][colSize];
        
        // Pacific
        final int flag1 = 1;
        for(int i=0;i<rowSize;i++) {
            if(map[i][0] < flag1) dfs(i,0,flag1);
        }
        for(int i=1;i<colSize;i++){
            if(map[0][i] < flag1) dfs(0,i,flag1);
        }
        
        // Atlantic
        final int flag2 = 2;
        int bottom = rowSize-1, right = colSize-1;
        for(int i=0;i<rowSize;i++){
            if(map[i][right] < flag2) dfs(i, right, flag2);
        }
        for(int i=0;i<right;i++){
            if(map[bottom][i] < flag2) dfs(bottom, i, flag2);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        final int flag3 = flag1 + flag2;
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(map[i][j] == flag3) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    
    private void dfs(int x, int y, int color) {
        // visit
        map[x][y] += color;
        
        // dfs
        int curHeight = heights[x][y];
        int nextX, nextY;
        for(int[] d : dirs) {
            nextX = x + d[0];
            nextY = y + d[1];
            
            if(nextX < 0 || nextX>=rowSize || nextY<0 || nextY>=colSize) continue;
            
            // 현재 높이보다 높거나 같은 이웃 셀로 전파
            if(heights[nextX][nextY] >= curHeight && map[nextX][nextY] < color) dfs(nextX, nextY, color);
        }
    }
}