class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        int curSum, curWidth, curHeight;
        for (int i = 0; i < height.length; i++) {
            // 스택의 숫자보다 현재 막대가 낮은 경우에는 그냥 저장
            // => 스택의 숫자는 내림차순
            if (stack.isEmpty() || stack.peek() >= height[i]) {
                stack.push(height[i]);
                continue;
            }

            // 현재 막대보다 낮은 막대들에 물을 채움
            curSum = 0;
            curWidth = 0;
            curHeight = height[i];
            while (!stack.isEmpty() && stack.peek() <= height[i]) {
                curHeight = stack.pop();
                curSum += curHeight;
                curWidth++;
            }

            // 스택이 비어있지 않으면 현재 높이가 물채우는 바운드가 됨
            if (!stack.isEmpty()) curHeight = height[i];

            // 현재 채운 물
            ans += curWidth * curHeight - curSum;

            // 물 채우고 난 뒤의 막대기 높이 저장 : 스택이 비어있지 않은 경우에만
            // 스택이 비어 있는 경우에는 이후 막대들만 고려하면됨
            if (!stack.isEmpty()) {
                for (int j = 0; j < curWidth; j++) stack.push(height[i]);
            }
            stack.push(height[i]);
        }


        return ans;
    }
}