class Solution {
    public int coinChange(int[] coins, int amount) {
        // Edge Case
        if (amount == 0) return 0;
        
        // 작은 돈부터 고려
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int coin : coins) {
            if(coin > amount) break;
            dp[coin] = 1;
        }

        // 각 돈에 대한 경우의 수 계산
        for (int pay = 1; pay <= amount; pay++) {
            if (dp[pay] != -1) continue;

            for (int coin : coins) {
                if (pay < coin) break;

                // coin 을 내는 경우 경우의 수
                if (dp[pay - coin] != -1) {
                    if (dp[pay] == -1) {
                        // 첫 발견
                        dp[pay] = dp[pay - coin] + 1;
                    } else {
                        // 이후 
                        dp[pay] = Math.min(dp[pay], dp[pay - coin] + 1);
                    }
                }
            }
        }

        return dp[amount];
    }
}