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
    public Node cloneTree(Node root) {
        if(root == null) return null;

        Node ans = new Node(root.val);
        
        // bfs : (old, new)
        Queue<Node[]> bfs = new ArrayDeque<>();
        bfs.add(new Node[] {root, ans});
        
        Node[] cur;
        Node old, copy, copyChild;
        while(!bfs.isEmpty()) {
            cur = bfs.poll();
            old = cur[0];
            copy = cur[1];
            
            for(Node child : old.children) {
                copyChild = new Node(child.val);
                copy.children.add(copyChild);
                
                bfs.add(new Node[]{child, copyChild});
            }
        }
        
        return ans;
    }
}