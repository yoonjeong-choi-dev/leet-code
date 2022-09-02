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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);

        TreeNode node;
        int curSize;
        double curSum;
        while(!bfs.isEmpty()) {
            curSize = bfs.size();
            curSum = 0;
            for(int i=0;i<curSize;i++){
                node = bfs.poll();
                curSum += node.val;

                if(node.left != null) bfs.add(node.left);
                if(node.right != null) bfs.add(node.right);
            }
            
            ans.add((double) curSum / curSize);
        }
        return ans;
    }
}