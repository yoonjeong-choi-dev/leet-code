class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valToIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valToIdx.containsKey(nums[i]) && i - valToIdx.get(nums[i]) <= k) return true;

            valToIdx.put(nums[i], i);
        }
        return false;
    }
}