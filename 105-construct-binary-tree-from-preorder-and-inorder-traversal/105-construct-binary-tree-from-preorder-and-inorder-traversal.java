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
    private int[] preorder, inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int end = preorder.length - 1;
        return recur(0, end, 0, end);
    }

    // preorder[start:end] 및 inorder[start:end] 서브트리에 대한 트리
    private TreeNode recur(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);

        // preorder 첫 요소가 현재 트리의 루트노드
        int root = preorder[preStart];
        
        // inorder : left->root->right
        int leftIdx = inStart;
        while (inorder[leftIdx] != root) leftIdx++;

        int leftTreeSize = leftIdx - inStart;
        
        // Recursive solution for left/right subtree
        TreeNode left = recur(preStart + 1, preStart + leftTreeSize, inStart, leftIdx - 1);
        TreeNode right = recur(preStart + leftTreeSize + 1, preEnd, leftIdx + 1, inEnd);
        return new TreeNode(root, left, right);
    }
}