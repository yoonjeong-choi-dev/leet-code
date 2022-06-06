class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;
        boolean allMatched;

        Character curChar;
        while (true) {
            allMatched = true;
            curChar = null;
            for (String s : strs) {
                if (idx >= s.length()) {
                    allMatched = false;
                    break;
                }

                if (curChar == null) {
                    curChar = s.charAt(idx);
                } else if (curChar != s.charAt(idx)) {
                    allMatched = false;
                    break;
                }
            }

            if (!allMatched) break;
            idx++;
        }

        return strs[0].substring(0, idx);
    }
}