class Solution {
    private List<List<Integer>> graph;
    private boolean[] isVisited;

    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) return -1;

        isVisited = new boolean[n];
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] con : connections) {
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }

        int numComponent = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                numComponent++;
                dfs(i);
            }
        }

        return numComponent - 1;
    }

    private void dfs(int node) {
        isVisited[node] = true;
        for (int next : graph.get(node)) {
            if (!isVisited[next]) dfs(next);
        }
    }
}