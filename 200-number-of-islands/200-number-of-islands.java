class Solution {
    
    private char[][] grid;
    int rowSize, colSize;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        rowSize = grid.length;
        colSize = grid[0].length;
        
        int ans = 0;
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(i,j);
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(int x, int y) {
        if(x<0 || x >= rowSize || y < 0 || y >= colSize) return;
        if(grid[x][y] == '0') return;
        
        grid[x][y] = '0';
        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);
    }
}