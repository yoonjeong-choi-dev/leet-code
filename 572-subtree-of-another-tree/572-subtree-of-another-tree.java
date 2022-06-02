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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (root.val == subRoot.val) {
            // 현재 노드를 루트로 하여 탐색
            // => 하위 서브트리들의 일치여부 : isSubtree 함수와는 다른 방식!
            if (isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)) return true;
        }

        // 현재 노드의 서브 트리에 대해서 탐색
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}