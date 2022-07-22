class Solution {
    private Map<Character, String> wordMap;
    private Set<String> isOccurred;
    private String pattern, s;

    public boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() > s.length()) return false;

        wordMap = new HashMap<>();
        isOccurred = new HashSet<>();
        this.pattern = pattern;
        this.s = s;

        return recur(0, 0);
    }

    private boolean recur(int pIdx, int sIdx) {
        if (pIdx == pattern.length() && sIdx == s.length()) return true;
        if (pIdx < pattern.length() && sIdx == s.length()) return false;
        if (pIdx == pattern.length() && sIdx < s.length()) return false;

        char curPattern = pattern.charAt(pIdx);
        String word;
        if (wordMap.containsKey(curPattern)) {
            word = wordMap.get(curPattern);
            
            if (sIdx + word.length() >= s.length() + 1) return false;
            
            boolean startWith = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != s.charAt(sIdx + i)) {
                    startWith = false;
                    break;
                }
            }

            if (!startWith) return false;
            return recur(pIdx + 1, sIdx + word.length());
        } else {
            for (int i = sIdx; i < s.length(); i++) {
                word = s.substring(sIdx, i + 1);
                if (isOccurred.contains(word)) continue;

                wordMap.put(curPattern, word);
                isOccurred.add(word);
                if (recur(pIdx + 1, sIdx + word.length())) return true;

                wordMap.remove(curPattern);
                isOccurred.remove(word);
            }
            return false;
        }
    }
}