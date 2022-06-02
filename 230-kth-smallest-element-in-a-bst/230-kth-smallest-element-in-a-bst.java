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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> inorder = new Stack<>();
        inorder.push(root);

        TreeNode cur, temp;
        while (true) {
            cur = inorder.pop();
            // leaf node : visit!
            if (cur.left == null && cur.right == null) {
                k--;
                if (k == 0) return cur.val;
                continue;
            }

            if (cur.right != null) {
                inorder.push(cur.right);
                cur.right = null;
            }

            temp = cur.left;
            cur.left = null;
            inorder.push(cur);

            if (temp != null) inorder.push(temp);
        }
    }
}