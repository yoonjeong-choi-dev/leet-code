class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> occurMap = new HashMap<>();
        for (int num : arr) occurMap.put(num, occurMap.getOrDefault(num, 0) + 1);

        // 빈도 수를 내림차순으로 정렬
        Integer[] sorted = new Integer[occurMap.size()];
        int idx = 0;
        for (int val : occurMap.values()) sorted[idx++] = val;
        Arrays.sort(sorted, Collections.reverseOrder());

        int ans = 0;
        int curRemoved = 0;
        int targetRemoved = arr.length / 2;
        while (curRemoved < targetRemoved) {
            curRemoved += sorted[ans++];
        }
        
        return ans;
    }
}