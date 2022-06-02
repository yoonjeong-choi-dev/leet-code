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
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> bfs = new ArrayDeque<>();

        // 현재 서브트리의 하한값 및 상한값
        Queue<int[]> boundaryInfo = new ArrayDeque<>();

        bfs.add(root);
        boundaryInfo.add(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE});

        TreeNode curNode;
        int[] curBound;

        while (!bfs.isEmpty()) {
            curNode = bfs.poll();
            curBound = boundaryInfo.poll();

            if (curNode.left != null) {
                if (curNode.val <= curNode.left.val) return false;
                if(curNode.left.val < curBound[0]) return false;
                bfs.add(curNode.left);
                boundaryInfo.add(new int[]{curBound[0], curNode.val - 1});
            }

            if(curNode.right != null) {
                if(curNode.val >= curNode.right.val) return false;
                if(curNode.right.val > curBound[1]) return false;
                bfs.add(curNode.right);
                boundaryInfo.add(new int[] {curNode.val+1, curBound[1]});
            }
        }

        return true;
    }
}