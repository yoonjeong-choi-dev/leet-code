class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if (size == 0) return 0;

        // height[0:i] 중 최대값
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        // height[i:size-1] 중 최대값
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        // i 번째 위치에 채워지는 물의 양 => 양옆의 최대값들에 의해 계산
        int ans = 0;
        for (int i = 0; i < size; i++) ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        return ans;
    }
}