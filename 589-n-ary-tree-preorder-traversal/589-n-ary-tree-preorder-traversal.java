/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Deque<Node> dfs = new ArrayDeque<>();
        dfs.add(root);
        
        Node cur;
        while(!dfs.isEmpty()) {
            cur = dfs.pop();
            ans.add(cur.val);
            
            Collections.reverse(cur.children);
            for(Node child : cur.children) {
                dfs.push(child);
            }
        }
        
        return ans;
    }
}