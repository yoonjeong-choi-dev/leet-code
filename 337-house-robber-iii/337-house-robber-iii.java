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
    
    private Map<TreeNode, Integer> ansParentRobbed = new HashMap<>();
    private Map<TreeNode, Integer> ansPrarentNotRobbed = new HashMap<>();
    
    public int rob(TreeNode root) {
        return recur(root, false);
    }

    private int recur(TreeNode node, boolean isParentRobbed) {
        if(node == null) return 0;
        
        if(isParentRobbed) {
            // 윗집이 훔쳐진 경우 => 현재 집 훔치기 불가능
            if(ansParentRobbed.containsKey(node)) return ansParentRobbed.get(node);
            
            // 아래집 훔치기
            int curAns = recur(node.left, false) + recur(node.right, false);
            ansParentRobbed.put(node, curAns);
            return curAns;
        } else {
            // 윗집이 훔쳐지지 않은 경우 => 현재 집 훔치기 가능
            if(ansPrarentNotRobbed.containsKey(node)) return ansPrarentNotRobbed.get(node);
            
            // 현재 집 훔치기
            int curAns = node.val +  recur(node.left, true) + recur(node.right, true);
            
            // 현재 집 훔치지 않기
            curAns = Math.max(curAns, recur(node.left, false) + recur(node.right, false));
            ansPrarentNotRobbed.put(node, curAns);
            return curAns;
        }
    }
}