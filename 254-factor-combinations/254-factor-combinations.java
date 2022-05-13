class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> getFactors(int n) {
        ans = new ArrayList<>();

        List<Integer> curPath = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                curPath.add(i);
                recursive(n / i, i, curPath);
                curPath.remove(0);
            }
        }

        return ans;
    }

    private void recursive(int curNumber, int lowFactor, List<Integer> curPath) {
        if (curNumber == 1) {
            List<Integer> curAns = new ArrayList<>(curPath);
            ans.add(curAns);
            return;
        }

        for (int i = lowFactor; i <= curNumber; i++) {
            if (curNumber % i == 0) {
                curPath.add(i);
                recursive(curNumber / i, i, curPath);
                curPath.remove(curPath.size() - 1);
            }
        }
    }
}