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

        // 자식이 null 인 경우도 있으므로 null 을 추가해놓는다
        covered.add(null);

        postOrder(root, null);

        return ans;
    }

    private void postOrder(TreeNode node, TreeNode parent) {
        if (node == null) return;

        // post order : left -> right -> root
        postOrder(node.left, node);
        postOrder(node.right, node);

        // 현재 노드에 카메라를 설치해야 하는 상황
        // 루트 노드인 경우 : post order 이므로, 현재 노드가 커버되지 않은 경우 카메라 설치 필요
        // 루트 노드가 아닌 경우 : 자식 노드들 중에 커버되지 않은 노드가 있는 경우
        // => 전략 : 자식보다는 부모 노드 쪽에 설치
        if ((parent == null && !covered.contains(node)) || (!covered.contains(node.left) || !covered.contains(node.right))) {
            ans++;
            
            covered.add(parent);
            covered.add(node);
            covered.add(node.left);
            covered.add(node.right);
        }
    }
}