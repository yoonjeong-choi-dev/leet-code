class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;

        int numFresh = 0;
        Queue<int[]> bfs = new ArrayDeque<>(rowSize * colSize);
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) numFresh++;
                else if (grid[i][j] == 2) bfs.add(new int[]{i, j});
            }
        }

        int time = 0;
        int[] curPos;
        int x, y;
        while (!bfs.isEmpty()) {
            if (numFresh == 0) return time;

            for (int i = bfs.size() - 1; i >= 0; i--) {
                curPos = bfs.poll();
                for (int[] d : directions) {
                    x = curPos[0] + d[0];
                    y = curPos[1] + d[1];

                    if (x < 0 || x >= rowSize || y < 0 || y >= colSize) continue;

                    if (grid[x][y] == 1) {
                        grid[x][y] = 0;
                        numFresh--;
                        bfs.add(new int[]{x, y});
                    }
                }
            }

            time++;
        }


        return numFresh == 0 ? time : -1;
    }
}