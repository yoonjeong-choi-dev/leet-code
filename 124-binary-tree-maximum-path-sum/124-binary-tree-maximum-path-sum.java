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

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        postOrderSum(root);
        return ans;
    }

    private int postOrderSum(TreeNode node) {
        // node 를 지나는 경로 계산
        if (node == null) return 0;

        int left = Math.max(postOrderSum(node.left), 0);
        int right = Math.max(postOrderSum(node.right), 0);

        // node를 루트로 할 때의 최대 경로
        int ret = left + right + node.val;
        if (ans < ret) ans = ret;

        // node 상위로 올라가는 경우
        ret = Math.max(left, right) + node.val;
        return ret;
    }
}