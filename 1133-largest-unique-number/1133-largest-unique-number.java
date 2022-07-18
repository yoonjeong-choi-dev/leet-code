class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> occurs = new HashMap<>();
        for (int num : nums) {
            occurs.put(num, occurs.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        for (int num : occurs.keySet()) {
            if (occurs.get(num) == 1) {
                ans = Math.max(ans, num);
            }
        }
        
        return ans;
    }
}