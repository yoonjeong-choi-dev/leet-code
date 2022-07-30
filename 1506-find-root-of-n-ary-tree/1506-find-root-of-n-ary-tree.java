/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        Map<Node, Integer> inDegree = new HashMap<>();
        for (Node node : tree) {
            if (!inDegree.containsKey(node)) inDegree.put(node, 0);

            for (Node child : node.children) {
                // node -> child
                inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            }
        }

        for (Node node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) return node;
        }

        // never reach
        return null;
    }
}