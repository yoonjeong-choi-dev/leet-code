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
class BSTIterator {
    
    private final Stack<TreeNode> dfs;

    public BSTIterator(TreeNode root) {
        dfs = new Stack<>();
        dfs.push(root);
    }
    
    public int next() {
        TreeNode cur, temp;
        while(true) {
            cur = dfs.pop();
            
            if(cur.left == null && cur.right == null) return cur.val;
            
            if(cur.right != null) dfs.push(cur.right);
            
            temp = cur.left;
            cur.left = cur.right = null;
            dfs.push(cur);
            
            if(temp != null) dfs.push(temp);
        }
    }
    
    public boolean hasNext() {
        return !dfs.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */