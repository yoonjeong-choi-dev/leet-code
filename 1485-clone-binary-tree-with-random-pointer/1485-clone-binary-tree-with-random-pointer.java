/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    private Map<Node, NodeCopy> oldToNew;

    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;

        oldToNew = new HashMap<>();

        Stack<Node> dfs = new Stack<>();
        dfs.push(root);

        Node cur;
        NodeCopy copy;
        while (!dfs.isEmpty()) {
            cur = dfs.pop();
            copy = getCopy(cur);

            copy.left = getCopy(cur.left);
            copy.right = getCopy(cur.right);
            copy.random = getCopy(cur.random);

            if (cur.left != null) dfs.add(cur.left);
            if (cur.right != null) dfs.add(cur.right);
        }

        return oldToNew.get(root);
    }

    private NodeCopy getCopy(Node node) {
        if (node == null) return null;

        if (!oldToNew.containsKey(node)) oldToNew.put(node, new NodeCopy(node.val));
        return oldToNew.get(node);
    }
}