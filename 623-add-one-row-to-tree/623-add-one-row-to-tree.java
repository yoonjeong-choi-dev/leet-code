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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode ret = new TreeNode(val);
            ret.left = root;
            return ret;
        }

        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        TreeNode cur;
        while (depth != 2) {
            for (int i = bfs.size(); i > 0; i--) {
                cur = bfs.poll();
                if (cur.left != null) bfs.add(cur.left);
                if (cur.right != null) bfs.add(cur.right);
            }
            depth--;
        }

        while (!bfs.isEmpty()) {
            cur = bfs.poll();
            TreeNode node = new TreeNode(val);
            node.left = cur.left;
            cur.left = node;

            node = new TreeNode(val);
            node.right = cur.right;
            cur.right = node;
        }

        return root;
    }
}