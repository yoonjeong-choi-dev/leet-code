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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;

        Stack<TreeNode> dfs = new Stack<>();
        dfs.push(root);

        TreeNode cur;
        while (!dfs.isEmpty()) {
            cur = dfs.pop();

            if (cur.val >= low && cur.val <= high) ans += cur.val;

            if (cur.left != null) dfs.push(cur.left);
            if (cur.right != null) dfs.push(cur.right);
        }
        return ans;
    }
}