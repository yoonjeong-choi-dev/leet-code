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
    
    private int[] inorder;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        inorder = nums;
        return convert(0, nums.length-1);
    }
    
    private TreeNode convert(int start, int end) {
        if(start > end) return null;
        
        int rootIdx = (start+end) / 2;
        TreeNode ret = new TreeNode(inorder[rootIdx]);
        ret.left = convert(start, rootIdx-1);
        ret.right = convert(rootIdx+1, end);
        return ret;
    }
}