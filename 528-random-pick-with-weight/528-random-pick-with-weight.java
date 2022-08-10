class Solution {

    private final Random random = new Random();
        private int totalSum;
        private int[] partialSum;

        public Solution(int[] w) {
            partialSum = new int[w.length];
            partialSum[0] = w[0];
            for (int i = 1; i < w.length; i++) partialSum[i] = partialSum[i - 1] + w[i];

            totalSum = partialSum[w.length - 1];
        }

        public int pickIndex() {
            // find i s.t partialSum[i-1] <= target < partialSum[i]
            int target = random.nextInt(totalSum);

            int idx = 0;
            for (; idx < partialSum.length; idx++) {
                if (target < partialSum[idx]) return idx;
            }
            return idx - 1;
        }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */