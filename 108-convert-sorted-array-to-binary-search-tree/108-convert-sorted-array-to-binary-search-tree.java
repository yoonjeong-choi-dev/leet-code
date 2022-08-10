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
    
    private int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return recur(0, nums.length-1);
    }
    
    private TreeNode recur(int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        
        int mid = start + (end - start) / 2;
        TreeNode ans = new TreeNode(nums[mid]);
        ans.left = recur(start, mid-1);
        ans.right = recur(mid+1, end);
        return ans;
    }
}