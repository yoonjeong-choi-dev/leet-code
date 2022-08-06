class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        // (node, parent)
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.add(new int[]{0,-1});
        visited[0] = true;
        
        int[] cur;
        while(!bfs.isEmpty()) {
            cur = bfs.poll();
            for(int next : graph.get(cur[0])) {
                if(next == cur[1]) continue;
                
                if(visited[next]) return false;
                visited[next] = true;
                bfs.add(new int[]{next, cur[0]});
            }
        }
        
        for(boolean v : visited) if(!v) return false;
        return true;
    }
}