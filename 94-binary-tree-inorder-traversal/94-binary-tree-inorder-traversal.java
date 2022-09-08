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
    
    private List<Integer> ans;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        if(root != null) recur(root);
        return ans;
    }
    
    private void recur(TreeNode node) {
        if(node.left != null) recur(node.left);
        ans.add(node.val);
        if(node.right != null) recur(node.right);
    }
}