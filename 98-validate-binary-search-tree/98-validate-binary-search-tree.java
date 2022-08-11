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
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> bfs = new ArrayDeque<>();
        Queue<int[]> bound = new ArrayDeque<>();
        
        bfs.add(root);
        bound.add(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE});
        
        TreeNode node;
        int[] curBound;
        int upper, lower;
        
        while(!bfs.isEmpty()) {
            node = bfs.poll();
            curBound = bound.poll();
            lower = curBound[0];
            upper = curBound[1];

            
            if(node.left != null) {
                if(node.left.val >= node.val || node.left.val < lower) return false;
                
                bfs.add(node.left);
                bound.add(new int[] {lower, node.val-1});
            }
            
            if(node.right != null) {
                if(node.right.val <= node.val || node.right.val > upper) return false;
                
                bfs.add(node.right);
                bound.add(new int[] {node.val+1, upper});
            }
        }
        
        return true;
    }
}