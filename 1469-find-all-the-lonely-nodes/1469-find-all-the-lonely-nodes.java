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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        TreeNode curNode;
        while (!bfs.isEmpty()) {
            curNode = bfs.poll();

            if (curNode.left == null && curNode.right != null) {
                ans.add(curNode.right.val);
            } else if (curNode.left != null && curNode.right == null) {
                ans.add(curNode.left.val);
            } 
            
            if(curNode.left != null) bfs.add(curNode.left);
            if(curNode.right != null) bfs.add(curNode.right);
        }

        return ans;
    }
}