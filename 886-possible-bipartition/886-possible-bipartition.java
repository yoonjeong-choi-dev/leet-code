class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        for(int[] edge : dislikes) {
            edge[0]--;
            edge[1]--;
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // color a person to 1 or -1
        int[] coloring = new int[n];
        Queue<Integer> bfs = new ArrayDeque<>();
        int curNode, curPart;
        for(int i=0;i<n;i++){
            if(coloring[i] != 0) continue;
            
            coloring[i] = 1;
            bfs.add(i);
            
            while(!bfs.isEmpty()) {
                curNode = bfs.poll();
                curPart = coloring[curNode];
                
                for(int next : graph.get(curNode)) {
                    if(coloring[next] == curPart) {
                        return false;
                    }
                    if(coloring[next] == 0) {
                        coloring[next] = -curPart;
                        bfs.add(next);
                    }
                }
            }
        }
        
        return true;
    }
}