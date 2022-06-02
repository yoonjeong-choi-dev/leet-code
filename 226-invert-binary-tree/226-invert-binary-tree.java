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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        Queue<TreeNode> bfs = new ArrayDeque<>(100);
        bfs.add(root);
        
        TreeNode curNode, temp;
        while(!bfs.isEmpty()) {
            curNode = bfs.poll();
            
            temp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = temp;
            
            if(curNode.left != null) bfs.add(curNode.left);
            if(curNode.right != null) bfs.add(curNode.right);
        }
        
        return root;
    }
}