class Solution {
    public int largestRectangleArea(int[] heights) {
        int numBoards = heights.length;

        // 높이에 대한 오름차순 스택
        Stack<Integer> monotonic = new Stack<>();

        int ans = heights[0];

        // heights[-1] 은 무한대라고 가정
        monotonic.push(-1);

        int height, curHeight, curWidth;
        for (int i = 0; i < numBoards; i++) {
            height = heights[i];

            // 현재 높이값 이상인 값들에 대해서 넓이 계산
            // (why) 스택에 저장된 값들은 현재 막대기에 의해서 더이상 확장이 불가능
            // 값이 같은 경우에도 현재 막대기에 의해 제한된다고 가정함 => 너비 계산에 대한 가정
            while (monotonic.peek() != -1 && heights[monotonic.peek()] >= height) {
                // 스택에 저장된 막대의 높이로 만들 수 있는 최대 직사각형
                curHeight = heights[monotonic.pop()];

                // 너비는 스택 다음에 저장된 막대기와 현재 막대기(i)에 의해 결정
                curWidth = i - monotonic.peek() - 1;
                ans = Math.max(ans, curHeight * curWidth);
            }

            monotonic.push(i);
        }

        // 스택에 남이 있는 막대기로 직사각형 만들기
        // => 로직 자체는 동일
        while (monotonic.peek() != -1) {
            curHeight = heights[monotonic.pop()];
            curWidth = numBoards - monotonic.peek() - 1;
            ans = Math.max(ans, curHeight * curWidth);
        }

        return ans;
    }
}