class Solution {
    public int maxProfit(int[] prices) {
        // 저점에서 사서 고점에서 판다
        // => local min 에서 사서 local max 에서 파는 것을 반복
        int numDays = prices.length - 1;
        int ans = 0;

        int localMin, localMax;
        int curDay = 0;
        while (curDay < numDays) {
            // 저점 찾기
            while (curDay < numDays && prices[curDay] >= prices[curDay + 1]) curDay++;
            localMin = prices[curDay];

            // 고점 찾기
            while (curDay < numDays && prices[curDay] <= prices[curDay + 1]) curDay++;
            localMax = prices[curDay];
            ans += localMax - localMin;
        }

        return ans;
    }
}