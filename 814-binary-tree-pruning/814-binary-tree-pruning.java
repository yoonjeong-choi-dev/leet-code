/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean ret = postOrder(root);
        return ret ? null : root;
    }

    private boolean postOrder(TreeNode node) {
        if (node == null) return true;

        boolean left = postOrder(node.left);
        boolean right = postOrder(node.right);

        if (left) node.left = null;
        if (right) node.right = null;

        return node.val == 0 && left && right;
    }
}