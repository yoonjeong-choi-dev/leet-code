/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private static final String NULL_SEP = "#";
    private static final String NEXT_SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);
        return sb.toString();
    }
    
    private void preorderSerialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(NULL_SEP).append(NEXT_SEP);
            return;
        }
        
        sb.append(node.val).append(NEXT_SEP);
        preorderSerialize(node.left, sb);
        preorderSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(NEXT_SEP);
        LinkedList<String> nodeData = new LinkedList<>(Arrays.asList(tokens));
        return inorderDeserialize(nodeData);
    }
    
    private TreeNode inorderDeserialize(LinkedList<String> nodeData) {
        String nodeVal = nodeData.getFirst();
        nodeData.removeFirst();
        
        if(nodeVal.equals(NULL_SEP)) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(nodeVal));
        node.left = inorderDeserialize(nodeData);
        node.right = inorderDeserialize(nodeData);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));