class Solution {
    public int titleToNumber(String columnTitle) {
        int ret = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            ret = ret * 26 + columnTitle.charAt(i) - 'A' + 1;
        }

        return ret;
    }
}