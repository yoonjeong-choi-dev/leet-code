class Solution {
    public int largestRectangleArea(int[] heights) {
        int totalWidth = heights.length;
        int ans = heights[0];
        
        // 낮은 높이를 만나면, 다음 높이들은 현재 낮은 높이에 의해 제한됨
        // => 이후 높이들을 이용하는 경우, 앞에 있던 낮은 높이에 의해 제한
        // 높이에 대한 오름차순으로 인덱스 저장
        Stack<Integer> monoStack = new Stack<>();
        
        // 0번 부터 사용하는 것을 고려하기 위해 -1 인덱스 저장
        monoStack.push(-1);
        
        int curWidth, curHeight, height;
        for(int i=0;i<totalWidth;i++){
            height = heights[i];
            
            // 현재 높이보다 높은 막대기들의 높이를 가지는 직사각형 계산 : 이후에는 스택에 있는 막대기 전체 사용이 불가능 하므로
            while(monoStack.peek() != -1 && heights[monoStack.peek()] >= height) {
                curHeight = heights[monoStack.pop()];
                
                // 모노 스택이므로, monoStack.peek() 과 i 사이에 값들은 curHeight 보다 크거가 같음
                // ex) Example1 - i== 4
                curWidth = i - monoStack.peek() -1;
                ans = Math.max(ans, curWidth*curHeight);
            }
            
            monoStack.push(i);
        }
        
        // 스택에 있는 나머지 높이들에 대해서도 계산
        while(monoStack.peek() != -1) {
            curHeight = heights[monoStack.pop()];
            curWidth = totalWidth - monoStack.peek() -1;
            ans = Math.max(ans, curWidth*curHeight);
        }
        return ans;
    }
}