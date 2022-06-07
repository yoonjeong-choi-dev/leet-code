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

    private static final String SEP_NULL = "#";
        private static final String SEP_NEXT = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder ans = new StringBuilder();
            preorderSerialize(root, ans);
            return ans.toString();
        }

        private void preorderSerialize(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(SEP_NULL).append(SEP_NEXT);
                return;
            }

            sb.append(String.valueOf(node.val)).append(SEP_NEXT);
            preorderSerialize(node.left, sb);
            preorderSerialize(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] tokens = data.split(SEP_NEXT);
            LinkedList<String> nodeData = new LinkedList<>(Arrays.asList(tokens));

            return preorderDeserialize(nodeData);
        }

        private TreeNode preorderDeserialize(LinkedList<String> list) {
            String cur = list.get(0);
            list.removeFirst();
            if (cur.equals(SEP_NULL)) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(cur));
            node.left = preorderDeserialize(list);
            node.right = preorderDeserialize(list);
            return node;
        }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));