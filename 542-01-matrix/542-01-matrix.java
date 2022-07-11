class Solution {
    
    private static final int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int rowSize = mat.length, colSize = mat[0].length;
        
        int[][] ans = new int[rowSize][colSize];
        
        Queue<int[]> bfs = new ArrayDeque<>();
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(mat[i][j] == 0) bfs.add(new int[] {i,j});
            }
        }
        
        int[] cur;
        int nextX, nextY;
        
        while(!bfs.isEmpty()) {
            cur = bfs.poll();
            
            for(int[] d : dirs) {
                nextX = cur[0] + d[0];
                nextY = cur[1] + d[1];
                
                if(nextX < 0 || nextX >= rowSize || nextY < 0 || nextY >= colSize) continue;
                
                // 방문하지 않은 경우
                if(mat[nextX][nextY] == 1 && ans[nextX][nextY] == 0) {
                    ans[nextX][nextY] = ans[cur[0]][cur[1]] + 1;
                    bfs.add(new int[]{nextX, nextY});
                }
            }
        }
        
        return ans;
    }
}