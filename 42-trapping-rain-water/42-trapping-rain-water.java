class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;

        // i번째 위치에 쌓이는 물 높이는 양쪽에서 가장 높은 막대기에 의존
        // left[i] : [0,i] 에서 최대값, right[i] : [i:len-1] 에서 최대값
        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) left[i] = Math.max(height[i], left[i - 1]);

        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) right[i] = Math.max(height[i], right[i + 1]);

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}