/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans, p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        this.p = p;
        this.q = q;

        recursive(root);
        return ans;
    }

    private boolean recursive(TreeNode curNode) {
        if (curNode == null) return false;

        int leftRet = recursive(curNode.left) ? 1 : 0;
        int rightRet = recursive(curNode.right) ? 1 : 0;

        int rootRet = (curNode == p || curNode == q) ? 1 : 0;

        int curRet = leftRet + rightRet + rootRet;

        // 왼쪽,오른쪽 서브트리에 답이 있거나, 현재 노드가 두 타겟 노드인 경우 + 왼쪽 Or 오른쪽 서브트리에 다른 노드가 존재
        if (curRet >= 2) {
            ans = curNode;
        }

        // 왼쪽,오른쪽 서브트리에 두 타겟 노드가 존재하거나, 현재 노드가 두 타겟 노드 중 하나인 경우
        return curRet != 0;
    }
}