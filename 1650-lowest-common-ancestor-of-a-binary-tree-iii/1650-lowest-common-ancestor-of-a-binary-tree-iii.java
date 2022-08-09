/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == q) return p;

        Set<Node> pToRoot = new HashSet<>();
        while (p.parent != null) {
            pToRoot.add(p);
            p = p.parent;
        }

        Node root = p;
        while (root != q) {
            if (pToRoot.contains(q)) return q;
            q = q.parent;
        }

        return root;
    }
}