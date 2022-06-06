class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean terminated;

        public TrieNode() {
            children = new HashMap<>();
            terminated = false;
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();

        // Add strings to trie
        TrieNode cur;
        for (String s : strs) {
            cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());

                cur = cur.children.get(c);
            }

            cur.terminated = true;
        }

        // find longest prefix
        int len = 0;
        cur = root;
        while (true) {
            // 특정 문자열의 끝에 온 경우
            if (cur.terminated) break;

            // 2갈래로 나뉘어 지는 경우
            if (cur.children.size() != 1) break;

            len++;
            cur = (TrieNode) cur.children.values().toArray()[0];
        }

        return strs[0].substring(0, len);
    }
}