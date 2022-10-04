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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        
        while(!bfs.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            for(int i=bfs.size();i>0;i--) {
                TreeNode cur = bfs.poll();
                curLevel.add(cur.val);
                
                if(cur.left != null) bfs.add(cur.left);
                if(cur.right != null) bfs.add(cur.right);
            }
            
            ans.add(curLevel);
        }
        
        return ans;
    }
}