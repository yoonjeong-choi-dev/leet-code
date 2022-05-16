class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        if (grid[0][0] == 1 || grid[rowSize - 1][colSize - 1] == 1) return -1;
        
        int[][] dist = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> bfs = new ArrayDeque<>();
        dist[0][0] = 1;
        bfs.add(new int[]{0, 0});

        int[] curPos;
        int x, y, nextX, nextY;
        while (!bfs.isEmpty()) {
            curPos = bfs.poll();
            x = curPos[0];
            y = curPos[1];

            for (int[] d : directions) {
                nextX = x + d[0];
                nextY = y + d[1];

                if (nextX < 0 || nextX >= rowSize || nextY < 0 || nextY >= colSize) continue;
                if (grid[nextX][nextY] == 0 && dist[nextX][nextY] == -1) {
                    dist[nextX][nextY] = dist[x][y] + 1;
                    bfs.add(new int[]{nextX, nextY});
                }
            }
        }

        return dist[rowSize - 1][colSize - 1];
    }
}