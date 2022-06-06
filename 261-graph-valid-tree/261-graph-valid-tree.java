class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Make adjacent graph
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] isVisited = new boolean[n];

        // BFS : (node, parent)
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.add(new int[]{0, -1});
        isVisited[0] = true;

        int[] cur;
        while (!bfs.isEmpty()) {
            cur = bfs.poll();

            for (int next : graph.get(cur[0])) {
                // 부모 노드는 무시
                if (next == cur[1]) continue;

                // 사이클 형성
                if (isVisited[next]) return false;

                isVisited[next] = true;
                bfs.add(new int[]{next, cur[0]});
            }
        }


        // 컴포넌트가 1개인지 확인
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) return false;
        }
        return true;
    }
}