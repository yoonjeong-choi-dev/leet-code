class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int leftNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') leftNum++;
            else {
                if (leftNum == 0) {
                    // add '('
                    ans++;
                } else {
                    leftNum--;
                }
            }
        }

        // add ')'
        ans += leftNum;
        return ans;
    }
}