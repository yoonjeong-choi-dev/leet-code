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
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        
        TreeNode cur;
        while(!bfs.isEmpty()) {
            cur = bfs.poll();
            if((cur.left == null) ^ (cur.right == null)) {
                if(cur.left != null) ans.add(cur.left.val);
                else ans.add(cur.right.val);
            }
            
            if(cur.left != null) bfs.add(cur.left);
            if(cur.right != null) bfs.add(cur.right);
        }
        return ans;
    }
}