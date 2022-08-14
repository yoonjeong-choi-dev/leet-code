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
    public int goodNodes(TreeNode root) {
        int ans = 0;
        
        // bfs
        Queue<TreeNode> bfs = new ArrayDeque<>();
        Queue<Integer> maxVal = new ArrayDeque<>();
        
        bfs.add(root);
        maxVal.add(root.val);
        
        TreeNode curNode;
        int curMax;
        while(!bfs.isEmpty()) {
            curNode = bfs.poll();
            curMax = maxVal.poll();

            // visit
            if(curNode.val >= curMax) ans++;
            
            if(curNode.left != null) {
                bfs.add(curNode.left);
                maxVal.add(Math.max(curMax, curNode.val));
            }

            if(curNode.right != null) {
                bfs.add(curNode.right);
                maxVal.add(Math.max(curMax, curNode.val));
            }
        }
        
        return ans;
    }
}