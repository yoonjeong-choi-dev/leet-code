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
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode curAns = root;

        Stack<TreeNode> dfs = new Stack<>();
        if(root.right !=null) {
            dfs.push(root.right);
            root.right = null;
        }
        
        if(root.left != null) {
            dfs.push(root.left);
            root.left = null;
        }
        
        TreeNode curNode;
        while (!dfs.isEmpty()) {
            curNode = dfs.pop();

            // leaf => visit!
            if (curNode.left == null && curNode.right == null) {
                curAns.right = curNode;
                curAns = curNode;
                continue;
            }

            // save right -> left -> node to the stack
            if (curNode.right != null) {
                dfs.push(curNode.right);
                curNode.right = null;
            }

            if (curNode.left != null) {
                dfs.push(curNode.left);
                curNode.left = null;
            }

            dfs.push(curNode);
        }
    }
}