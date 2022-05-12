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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        TreeNode levelEndIndicator = new TreeNode(-1);
        bfs.offer(levelEndIndicator);

        TreeNode curNode;

        while (!bfs.isEmpty()) {

            while (bfs.peek() != levelEndIndicator) {
                curNode = bfs.poll();
                if (curNode == u) {
                    return bfs.peek() == levelEndIndicator ? null : bfs.poll();
                }

                if (curNode.left != null) bfs.offer(curNode.left);
                if (curNode.right != null) bfs.offer(curNode.right);
            }

            bfs.poll();
            bfs.offer(levelEndIndicator);
        }

        return null;
    }
}