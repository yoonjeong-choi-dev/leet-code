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
        
        Queue<TreeNode> bfs = new ArrayDeque<>();
        Queue<Integer> max = new ArrayDeque<>();
        bfs.add(root);
        max.add(root.val);
        
        TreeNode curNode;
        int curMax, nextMax;
        while(!bfs.isEmpty()) {
            curNode = bfs.poll();
            curMax = max.poll();
            
            if(curNode.val >= curMax) ans++;
            
            nextMax = Math.max(curMax, curNode.val);
            
            if(curNode.left != null) {
                bfs.add(curNode.left);
                max.add(nextMax);
            }
            
            if(curNode.right != null) {
                bfs.add(curNode.right);
                max.add(nextMax);
            }
        }
        return ans;
        
    }
}