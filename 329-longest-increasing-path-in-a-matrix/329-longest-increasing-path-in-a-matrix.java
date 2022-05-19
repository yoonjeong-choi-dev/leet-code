class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int[][] matrix;
    private int[][] cache;
    private int rowSize, colSize;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        rowSize = matrix.length;
        colSize = matrix[0].length;

        // cache[i][j] : (i,j) 로 시작할 때 최대 길이
        cache = new int[rowSize][colSize];

        int ans = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int x, int y) {
        if (cache[x][y] != 0) return cache[x][y];

        int nextX, nextY;
        for (int[] d : directions) {
            nextX = x + d[0];
            nextY = y + d[1];
            if (nextX < 0 || nextX >= rowSize || nextY < 0 || nextY >= colSize) continue;

            // 값이 커지는 경로로 탐색
            if (matrix[x][y] < matrix[nextX][nextY]) {
                cache[x][y] = Math.max(cache[x][y], dfs(nextX, nextY));
            }
        }

        // 현재 요소를 포함시켜야 하므로 +1
        cache[x][y] += 1;
        return cache[x][y];
    }
}