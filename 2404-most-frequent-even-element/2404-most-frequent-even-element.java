class Solution {
    public int mostFrequentEven(int[] nums) {
        int ans = -1, bestCount = 0;
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 1) continue;

            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (bestCount < counter.get(num) || (bestCount == counter.get(num) && ans > num)) {
                ans = num;
                bestCount = counter.get(num);
            }
        }

        return ans;
    }
}