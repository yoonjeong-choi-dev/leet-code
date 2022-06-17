class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // 0 <= nums[i] <= 1000 && 0 <= sum(nums[i]) <= 1000
        // 최대값은 모두 다 더한 totalSum, 최소값은 모두 다 뺀 -totalSum
        // => [-totalSum,totalSum] 범위 안에 모든 경우가 다 들어가 있음
        int dpSize = 2 * totalSum + 1;

        // dp[i] = (i-totalSum) 에 대한 경우의 수
        // <=> target 에 대한 경우의 수 : dp[target+totalSum]
        int[] dp = new int[dpSize];

        // 첫번째 단계 업데이트
        // 0인 경우에는 경우의 수가 2이므로 대입 대신 += 연산 사용
        dp[nums[0] + totalSum] += 1;
        dp[-nums[0] + totalSum] += 1;

        // 두번째 요소부터 bottom-up
        int[] next;
        for (int i = 1; i < len; i++) {
            // next : 다음 단계에 대한 dp
            next = new int[dpSize];

            for (int sum = -totalSum; sum <= totalSum; sum++) {
                // nums[:i] 까지의 부분 문제에 대해 유효한 경로가 있는 경우
                if(dp[sum+totalSum] != 0) {
                    next[sum + nums[i] + totalSum] += dp[sum + totalSum];
                    next[sum - nums[i] + totalSum] += dp[sum + totalSum];
                }
            }

            dp = next;
        }

        return Math.abs(target) <= totalSum ? dp[target + totalSum] : 0;
    }
}