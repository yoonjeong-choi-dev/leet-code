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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> dfs = new Stack<>();
        dfs.push(root);
        
        TreeNode cur,temp;
        while(!dfs.isEmpty()) {
            cur = dfs.pop();
            
            // leaf node
            if(cur.left == null && cur.right == null) {
                k--;
                if(k==0) return cur.val;
                continue;
            }
            
            // inorder : left -> cur -> right
            if(cur.right != null) dfs.push(cur.right);
            
            temp = cur.left;
            cur.right = null;
            cur.left = null;
            dfs.push(cur);
            
            if(temp != null) dfs.push(temp);
        }
        
        // never reach
        return -1;
    }
}