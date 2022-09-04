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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> [row,node.val]
        Map<Integer, List<int[]>> colInfo = new HashMap<>();
        
        
        Queue<TreeNode> bfs = new ArrayDeque<>();
        
        // [row, col]
        Queue<int[]> posQ = new ArrayDeque<>();
        bfs.add(root);
        posQ.add(new int[]{0,0});
        
        TreeNode curNode;
        int[] curPos;
        while(!bfs.isEmpty()){
            curNode = bfs.poll();
            curPos = posQ.poll();
            
            if(!colInfo.containsKey(curPos[1])) colInfo.put(curPos[1], new ArrayList<>());
            colInfo.get(curPos[1]).add(new int[] {curPos[0], curNode.val});
            
            if(curNode.left != null) {
                bfs.add(curNode.left);
                posQ.add(new int[] {curPos[0]+1, curPos[1]-1});
            }
            
            if(curNode.right != null) {
                bfs.add(curNode.right);
                posQ.add(new int[]{curPos[0]+1, curPos[1]+1});
            }
        }
        
        
        int minCol=0,maxCol=0;
        for(int col : colInfo.keySet()) {
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> curColInfo;
        List<Integer> curAns;
        for(int i=minCol;i<=maxCol;i++){
            if(!colInfo.containsKey(i)) continue;
            
            curColInfo = colInfo.get(i);
            Collections.sort(curColInfo, new Comparator<>(){
               public int compare(int[] o1, int[] o2) {
                   if(o1[0] != o2[0]) return o1[0] - o2[0];
                   else return o1[1] - o2[1];
               } 
            });
            
            curAns = new ArrayList<>();
            for(int[] info : curColInfo) curAns.add(info[1]);
            ans.add(curAns);
        }
        
        return ans;
    }
    
}