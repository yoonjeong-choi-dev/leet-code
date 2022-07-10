class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // f(n) = min(f(n-1), f(n-2)) + cost[n]
        int numStairs = cost.length;
        
        for(int i=2;i<numStairs;i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        
        return Math.min(cost[numStairs-1], cost[numStairs-2]);
    }
}