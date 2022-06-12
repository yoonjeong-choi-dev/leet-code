class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] ans = new int[size];

        // 온도에 대한 내림차순 스택
        Stack<Integer> monotonic = new Stack<>();

        for (int curDay = 0; curDay < size; curDay++) {
            int curTemper = temperatures[curDay];

            // 현재 온도보다 낮은 이전 온도 날짜 업데이트 
            while (!monotonic.isEmpty() && temperatures[monotonic.peek()] < curTemper) {
                int prevDay = monotonic.pop();
                ans[prevDay] = curDay - prevDay;
            }

            monotonic.push(curDay);
        }
        return ans;
    }
}