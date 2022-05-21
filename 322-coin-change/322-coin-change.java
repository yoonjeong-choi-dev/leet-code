class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        // 작은 돈부터 고려
        Arrays.sort(coins);

        // dp[i] : i원을 낼 수 있는 경우의 수
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        for (int pay = 1; pay <= amount; pay++) {
            for (int coin : coins) {

                // pay를 거스르기 위한 coin 내기
                if (pay < coin) continue;
                if (pay == coin) {
                    // 오름차순 정렬을 했기 때문에 이후 코인의 값은 현재 값보다 큼
                    dp[pay] = 1;
                    break;
                }

                // pay-coin 의 경우의 수 + 1(현재 코인 내기)
                if (dp[pay - coin] != -1) {
                    if(dp[pay] == -1) {
                        // 처음 찾은 정답
                        dp[pay] = dp[pay - coin] + 1;
                    } else {
                        // 두번째 이후 찾은 정답은 최소값
                        dp[pay] = Math.min(dp[pay], dp[pay - coin] + 1);
                    }
                }
            }
        }


        return dp[amount];
    }
}