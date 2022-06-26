class Solution {
    public int coinChange(int[] coins, int amount) {
        
        
        // 낮은 코인부터 고려
        Arrays.sort(coins);
        
        // dp[i] : i원을 내기 위한 가장 작은 코인 갯수
        int[] dp = new int[amount+1];
        
        // -1 로 초기화
        Arrays.fill(dp, -1);
        
        // 코인 1개로 낼 수 있는 경우
        for(int coin : coins) {
            if(coin <= amount) dp[coin] = 1;
        }
        
        // 0원을 낼 수 있는 경우는 0
        dp[0] = 0;
        
        // 0원부터 탐색
        for(int money=1;money<=amount;money++){
            if(dp[money] != -1) continue;
            
            // money-coin 에 coin 추가
            for(int coin : coins){
                if(money < coin) break;
                
                if(dp[money-coin] != -1) {
                    if(dp[money] == -1) {
                        // 처음 발견한 정답
                        dp[money] = dp[money-coin] + 1;
                    } else {
                        // 두번째 이후 발견
                        dp[money] = Math.min(dp[money], dp[money-coin] + 1);
                    }
                }
            }
        }
        
        return dp[amount];
    }
}