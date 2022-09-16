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
    
    private int ans;
    private Set<TreeNode> covered;
    
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet<>();
        covered.add(null);
        
        postOrder(root, null);
        return ans;
    }
    
    private void postOrder(TreeNode node, TreeNode parent) {
        if(node == null) return;
        
        postOrder(node.left, node);
        postOrder(node.right, node);
        
        // 루트 노드가 커버되지 않은 경우 Or 자식 노드가 커버되지 않은 경우 설치
        // 자신만 커버 되지 않는 경우에는 부모 노드에 설치해준다
        if((parent == null && !covered.contains(node)) || (!covered.contains(node.left) || !covered.contains(node.right))) {
            covered.add(parent);
            covered.add(node);
            covered.add(node.left);
            covered.add(node.right);
            ans++;
        }
    }
}