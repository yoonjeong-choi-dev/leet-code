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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        TreeNode curNode;

        while (!bfs.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>(bfs.size());
            for (int i = bfs.size() - 1; i >= 0; i--) {
                curNode = bfs.poll();
                curLevel.add(curNode.val);

                if (curNode.left != null) bfs.add(curNode.left);
                if (curNode.right != null) bfs.add(curNode.right);
            }
            ans.add(curLevel);
        }

        return ans;
    }
}