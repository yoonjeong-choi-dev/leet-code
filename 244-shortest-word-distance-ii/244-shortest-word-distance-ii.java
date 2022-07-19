class WordDistance {

        private final Map<String, List<Integer>> wordPos = new HashMap<>();

        public WordDistance(String[] wordsDict) {
            int idx = 0;
            for (String word : wordsDict) {
                if (!wordPos.containsKey(word)) wordPos.put(word, new ArrayList<>());

                wordPos.get(word).add(idx++);
            }
        }

        public int shortest(String word1, String word2) {
            int ans = Integer.MAX_VALUE;

            List<Integer> pos1 = wordPos.get(word1);
            List<Integer> pos2 = wordPos.get(word2);

            int idx1 = 0, idx2 = 0;
            int len1 = pos1.size(), len2 = pos2.size();
            while (idx1 < len1 && idx2 < len2) {
                ans = Math.min(ans, Math.abs(pos1.get(idx1) - pos2.get(idx2)));

                if (pos1.get(idx1) < pos2.get(idx2)) {
                    idx1++;
                } else {
                    idx2++;
                }
            }

            return ans;
        }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */