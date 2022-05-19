class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        if (rowSize == 0) return 0;

        // 가장 자리에 패딩을 줌
        int[][] graph = new int[rowSize + 2][colSize + 2];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                graph[i + 1][j + 1] = matrix[i][j];
            }
        }

        // 값이 높아지는 방향으로 그래프가 연결되어 있다고 가정하고, out-degree 계산
        int[][] outDegree = new int[rowSize + 2][colSize + 2];
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                for (int[] d : directions) {
                    if (graph[i][j] < graph[i + d[0]][j + d[1]]) outDegree[i][j]++;
                }
            }
        }

        // graph 크기 
        rowSize += 2;
        colSize += 2;

        // 위상 정렬 : out-degree 가 0인 노드들이 리프 노드
        // i.e 주변 값보다 큰 그리드 셀
        // => 위상 정렬의 탐색 순서는 내림차순으로 됨
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < rowSize - 1; i++) {
            for (int j = 1; j < colSize - 1; j++) {
                if (outDegree[i][j] == 0) leaves.add(new int[]{i, j});
            }
        }

        // 위상 정렬 시, 위상 정렬 트리의 높이가 정답 : 최대 길이
        int height = 0;

        // 모든 리프 노드들이 사라질 때까지 수행
        List<int[]> nextLeaves;
        int nextX, nextY;
        while (!leaves.isEmpty()) {
            height++;

            // 현재 리프 노드들을 삭제했을 때 생성되는 리프 노드들 검색
            nextLeaves = new ArrayList<>();
            for (int[] leaf : leaves) {
                for (int[] d : directions) {
                    nextX = leaf[0] + d[0];
                    nextY = leaf[1] + d[1];

                    if (graph[leaf[0]][leaf[1]] > graph[nextX][nextY]) {
                        // 리프 노드로 진입하는 노드들의 Out-degree -1 및 리프 노드 확인
                        outDegree[nextX][nextY]--;
                        if (outDegree[nextX][nextY] == 0) nextLeaves.add(new int[]{nextX, nextY});
                    }
                }
            }

            leaves = nextLeaves;
        }

        return height;
    }
}