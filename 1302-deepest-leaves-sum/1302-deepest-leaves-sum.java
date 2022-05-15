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
    public int deepestLeavesSum(TreeNode root) {
        int ans;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        TreeNode curNode;
        while (true) {
            ans = 0;
            for (int i = bfs.size(); i > 0; i--) {
                curNode = bfs.poll();
                ans += curNode.val;

                if (curNode.left != null) bfs.add(curNode.left);
                if (curNode.right != null) bfs.add(curNode.right);
            }

            if(bfs.isEmpty())
                return ans;
        }
    }
}