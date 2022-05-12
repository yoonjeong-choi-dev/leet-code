class Solution {
    private List<List<Integer>> ans;
    private Map<Integer, Integer> counters;
    private int[] curPath;
    private int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        counters = new HashMap<>();
        curPath = new int[len];

        for (int num : nums) {
            counters.put(num, counters.getOrDefault(num, 0) + 1);
        }

        int totalCount = factorial(len);
        for (int num : counters.values()) totalCount /= factorial(num);
        ans = new ArrayList<>(totalCount);
        
        recursive(0);
        return ans;
    }

    private void recursive(int curIdx) {
        if (curIdx == len) {
            List<Integer> curAns = new ArrayList<Integer>(len);
            for (int num : curPath) curAns.add(num);
            ans.add(curAns);
            return;
        }

        for (int num : counters.keySet()) {
            int curCount = counters.get(num);
            if (curCount != 0) {
                counters.put(num, curCount - 1);
                curPath[curIdx] = num;
                recursive(curIdx + 1);
                counters.put(num, curCount);
            }
        }
    }

    private int factorial(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) ret *= i;
        return ret;
    }
}