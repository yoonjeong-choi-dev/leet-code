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
    public boolean isSymmetric(TreeNode root) {
        // ArrayDeque 은 Null 을 저장하지 못함
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        bfs.add(root);
        
        TreeNode left, right;
        while(!bfs.isEmpty()) {
            left = bfs.poll();
            right = bfs.poll();
            
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            
            
            bfs.add(left.left);
            bfs.add(right.right);
            
            bfs.add(left.right);
            bfs.add(right.left);
        }
        return true;
    }
}