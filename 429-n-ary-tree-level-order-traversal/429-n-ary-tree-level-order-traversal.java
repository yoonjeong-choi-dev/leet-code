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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Node> bfs = new ArrayDeque<>();
        bfs.add(root);
        
        Node curNode;
        List<Integer> curAns;
        
        while(!bfs.isEmpty()) {
            curAns = new ArrayList<>();
            for(int i=bfs.size();i>0;i--){
                curNode = bfs.poll();
                curAns.add(curNode.val);
                
                for(Node next : curNode.children) {
                    bfs.add(next);
                }
            }
            ans.add(curAns);
        }
        
        return ans;
    }
}