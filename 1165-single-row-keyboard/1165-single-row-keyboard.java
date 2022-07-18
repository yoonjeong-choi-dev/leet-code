class Solution {
    public int calculateTime(String keyboard, String word) {
        // keyboard contains each English lowercase letter exactly once in some order.
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            index[keyboard.charAt(i) - 'a'] = i;
        }

        int pos = 0, curPos;
        int ans = 0;

        for (char c : word.toCharArray()) {
            curPos = index[c - 'a'];
            ans += Math.abs(pos - curPos);

            pos = curPos;
        }

        return ans;
    }
}