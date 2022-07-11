/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private Map<Node, Node> oldToNew;
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        oldToNew = new HashMap<>();
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> bfs = new ArrayDeque<>();
        bfs.add(node);
        visited.add(node);
        
        Node curNode, cloneNode;
        while(!bfs.isEmpty()) {
            curNode = bfs.poll();
            cloneNode = getClone(curNode);
            
            for(Node neighbor : curNode.neighbors) {
                cloneNode.neighbors.add(getClone(neighbor));
                
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    bfs.add(neighbor);
                }
            }
        }
        
        return oldToNew.get(node);
    }
    
    private Node getClone(Node node) {
        if(node == null) return null;
        
        if(!oldToNew.containsKey(node)) {
            oldToNew.put(node, new Node(node.val));
        }
        
        return oldToNew.get(node);
    }
}