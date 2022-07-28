class Solution {
    private String s1, s2, s3;
    int[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        cache = new int[s1.length()][s2.length()];

        return recursive(0, 0);
    }

    private boolean recursive(int idx1, int idx2) {
        if (idx1 == s1.length()) {
            for (int i = idx2; i < s2.length(); i++) {
                if (s2.charAt(i) != s3.charAt(idx1 + i)) return false;
            }
            return true;
        }

        if (idx2 == s2.length()) {
            for (int i = idx1; i < s1.length(); i++) {
                if (s1.charAt(i) != s3.charAt(idx2 + i)) return false;
            }
            return true;
        }

        if (cache[idx1][idx2] != 0) return cache[idx1][idx2] == 1;

        int curTargetIdx = idx1 + idx2;

        boolean ans = (s3.charAt(curTargetIdx) == s1.charAt(idx1) && recursive(idx1 + 1, idx2))
                || (s3.charAt(curTargetIdx) == s2.charAt(idx2) && recursive(idx1, idx2 + 1));

        cache[idx1][idx2] = ans ? 1 : -1;
        return ans;
    }
}