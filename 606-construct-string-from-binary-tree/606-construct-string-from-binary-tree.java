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
    private StringBuilder sb;

    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        preOrder(root);
        return sb.toString();
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            sb.append("");
            return;
        }

        if (node.left == null && node.right == null) {
            sb.append(node.val);
            return;
        }

        sb.append(node.val).append("(");
        preOrder(node.left);
        sb.append(")");

        if (node.right != null) {
            sb.append("(");
            preOrder(node.right);
            sb.append(")");
        }

    }
}