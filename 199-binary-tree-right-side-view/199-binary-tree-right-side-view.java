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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);

        TreeNode cur;
        while (!bfs.isEmpty()) {
            for (int i = bfs.size() - 1; i >= 0; i--) {
                cur = bfs.poll();
                if (cur.left != null) bfs.add(cur.left);
                if (cur.right != null) bfs.add(cur.right);

                if (i == 0) ans.add(cur.val);
            }
        }

        return ans;
    }
}