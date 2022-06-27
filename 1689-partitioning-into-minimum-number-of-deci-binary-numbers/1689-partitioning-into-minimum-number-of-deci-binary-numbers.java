class Solution {
    public int minPartitions(String n) {
        // 가장 높은 숫자만큼 필요
        int ans = 1;
        for (char c : n.toCharArray()) {
            ans = Math.max(ans, c - '0');
        }
        
        return ans;
    }
}