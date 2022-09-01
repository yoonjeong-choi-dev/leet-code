class Solution {
    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;

        int ans = 0;

        // A pair (i, j) is called good if nums[i] == nums[j] and i < j
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) ans++;
            }
        }
        return ans;
    }
}