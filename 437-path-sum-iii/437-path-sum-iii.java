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
    
    private int ans, target;
    private Map<Long, Integer> distanceFromRoot;
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        
        ans = 0;
        target = targetSum;
        distanceFromRoot = new HashMap<>();
        
        recur(root, 0);
        return ans;
    }
    
    private void recur(TreeNode node, long curSum) {
        curSum += node.val;
        if(curSum == target) ans++;
        
        // curSum - (조상 노드 거리) == target
        ans += distanceFromRoot.getOrDefault(curSum - target, 0);
        
        // update distance
        distanceFromRoot.put(curSum, distanceFromRoot.getOrDefault(curSum, 0) + 1);
        
        if(node.left != null) recur(node.left, curSum);
        if(node.right != null) recur(node.right, curSum);
        
        distanceFromRoot.put(curSum, distanceFromRoot.get(curSum) -1);
    }
}