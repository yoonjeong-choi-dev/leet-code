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
    
    private List<List<Integer>> ans;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        
        List<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path);
        return ans;
    }
    
    private void dfs(TreeNode node, int remain, List<Integer> path) {
        // leaf node 
        if(node.left == null && node.right == null) {
            if(node.val == remain) {
                List<Integer> curAns = new ArrayList<>(path);
                curAns.add(node.val);
                ans.add(curAns);
            }
        }
        
        path.add(node.val);
        remain -= node.val;
        if(node.left != null) dfs(node.left, remain, path);
        if(node.right != null) dfs(node.right, remain, path);
        
        path.remove(path.size()-1);
    }
}