class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int[][] heights;
    private int rowSize, colSize;
    private int[][] result;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rowSize = heights.length;
        colSize = heights[0].length;
        result = new int[rowSize][colSize];

        final int pacificFlag = 1;
        final int atlanticFlag = 2;

        // Pacific
        for (int i = 0; i < rowSize; i++) {
            if (result[i][0] < pacificFlag) dfs(i, 0, pacificFlag);
        }
        for (int i = 0; i < colSize; i++) {
            if (result[0][i] < pacificFlag) dfs(0, i, pacificFlag);
        }

        // Atlantic
        for (int i = 0; i < rowSize; i++) {
            if (result[i][colSize - 1] < atlanticFlag) dfs(i, colSize - 1, atlanticFlag);
        }
        for (int i = 0; i < colSize; i++) {
            if (result[rowSize - 1][i] < atlanticFlag) dfs(rowSize - 1, i, atlanticFlag);
        }

        final int bothFlag = pacificFlag + atlanticFlag;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (result[i][j] == bothFlag) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, int flag) {
        result[x][y] += flag;

        int nextX, nextY;
        for (int[] d : directions) {
            nextX = x + d[0];
            nextY = y + d[1];
            if (nextX < 0 || nextX >= rowSize || nextY < 0 || nextY >= colSize) continue;

            // 원래는 높은곳에서 낮거나 같은 곳으로 물이 흐름
            // 바닷가에서 시작하여 반대 방향(낮은곳에서 높거나 같은 곳)으로 dfs 탐색하도록 변경
            if (heights[x][y] <= heights[nextX][nextY] && result[nextX][nextY] < flag) {
                dfs(nextX, nextY, flag);
            }
        }
    }
}