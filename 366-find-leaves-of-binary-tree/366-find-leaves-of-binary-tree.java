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
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        removeLeaf(root);
        return ans;
    }
    
    // 노드를 루트로 하는 트리의 높이 반환
    // => 리프 노드인 경우 1 반환
    private int removeLeaf(TreeNode node) {
        if(node == null) return 0;
        
        
        int leftH = removeLeaf(node.left);
        int rightH = removeLeaf(node.right);
        
        int curH = 1 + Math.max(leftH, rightH);
        if(ans.size() < curH) ans.add(new ArrayList<>());
        
        ans.get(curH-1).add(node.val);
        
        return curH;
    }
}