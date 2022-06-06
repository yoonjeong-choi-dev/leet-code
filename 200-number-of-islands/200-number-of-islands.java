class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private char[][] grid;
    private int rowSize, colSize;
    private boolean[][] isVisited;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        rowSize = grid.length;
        colSize = grid[0].length;
        isVisited = new boolean[rowSize][colSize];

        int numComponent = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    numComponent++;
                    dfs(i, j);
                }
            }
        }
        return numComponent;
    }

    private void dfs(int x, int y) {
        isVisited[x][y] = true;

        int nextX, nextY;
        for (int[] d : directions) {
            nextX = x + d[0];
            nextY = y + d[1];

            if (nextX < 0 || nextX >= rowSize || nextY < 0 || nextY >= colSize) continue;
            if (grid[nextX][nextY] == '1' && !isVisited[nextX][nextY]) dfs(nextX, nextY);
        }
    }
}