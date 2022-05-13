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
        getHeight(root);

        return ans;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        int curHeight = Math.max(left, right) + 1;

        while (ans.size() < curHeight) ans.add(new ArrayList<>());
        ans.get(curHeight - 1).add(node.val);

        return curHeight;
    }
}