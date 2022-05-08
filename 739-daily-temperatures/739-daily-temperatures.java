class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] ans = new int[size];

        // i ~ size-1 중에 가장 높은 온도
        int curMax = Integer.MIN_VALUE;
        int curTemp, days;

        // 이후에 따뜻해지는 날을 찾아야 하므로 거꾸로 계산
        for (int i = size - 1; i >= 0; i--) {
            curTemp = temperatures[i];

            // 현재 온도가 i ~ size-1 중에 가장 높은 온도
            // => i 온도는 따뜻해질 가능성 X
            if (curMax <= curTemp) {
                curMax = curTemp;
                continue;
            }

            days = 1;
            while (temperatures[i + days] <= curTemp) {
                // 현재 온도보다 따뜻한 최소 날짜 찾기
                days += ans[i + days];
            }
            ans[i] = days;
        }
        return ans;
    }
}