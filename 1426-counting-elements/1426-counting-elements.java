class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> counters = new HashMap<>();
        for(int n : arr) {
            counters.put(n, counters.getOrDefault(n, 0) + 1);
        }
        
        int ans = 0;
        for(int curNum : counters.keySet()) {
            if(counters.containsKey(curNum+1)) ans += counters.get(curNum);
        }
        
        return ans;
    }
}