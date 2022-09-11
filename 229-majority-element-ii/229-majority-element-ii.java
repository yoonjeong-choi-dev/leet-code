class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int targetCount = nums.length / 3 + 1;

        HashMap<Integer, Integer> counter = new HashMap<>();
        int curCount;
        for (int num : nums) {
            curCount = counter.getOrDefault(num, 0);
            if (curCount == targetCount) continue;

            counter.put(num, curCount + 1);
            if (counter.get(num) == targetCount) ans.add(num);
        }
        
        return ans;
    }
}