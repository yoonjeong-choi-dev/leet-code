class Solution {
    public boolean equationsPossible(String[] equations) {
        // Build a graph 
        List<List<Integer>> graph = new ArrayList<>();
        
        // variables : lowercase letter
        for(int i=0;i<26;i++) graph.add(new ArrayList<>());
        
        int from, to;
        for(String eq : equations) {
            if(eq.charAt(1) == '=') {
                from = eq.charAt(0) - 'a';
                to = eq.charAt(3) -'a';
                
                
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
        }
        
        int[] components = new int[26];
        Arrays.fill(components, -1);
        
        Deque<Integer> dfs = new ArrayDeque<>();
        int curComponent = 0, cur;
        for(int i=0;i<26;i++){
            if(components[i] == -1) {
                dfs.push(i);
                components[i] = curComponent;
                
                while(!dfs.isEmpty()) {
                    cur = dfs.pop();
                    for(int next : graph.get(cur)) {
                        if(components[next] == -1) {
                            components[next] = curComponent;
                            dfs.push(next);
                        }
                    }
                }
                curComponent++;
            }
        }
        
        for(String eq : equations) {
            if(eq.charAt(1) == '!') {
                from = eq.charAt(0) - 'a';
                to = eq.charAt(3) -'a';
                
                
                if(from == to || components[from] == components[to]) return false;
            }
        }
        return true;
    }
}