    class Solution {

        private final Random random = new Random();
        private final Map<Integer, List<Integer>> valToIndex = new HashMap<>();

        public Solution(int[] nums) {
            int val;
            for (int i = 0; i < nums.length; i++) {
                val = nums[i];
                if (!valToIndex.containsKey(val)) valToIndex.put(val, new ArrayList<>());

                valToIndex.get(val).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indices = valToIndex.get(target);
            int idx = random.nextInt(indices.size());
            return indices.get(idx);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */