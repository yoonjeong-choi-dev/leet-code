class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> first = new HashMap<>();
        
        int curSum;
        for(int n1 : nums1) {
            for(int n2 : nums2) {
                curSum = n1 + n2;
                first.put(curSum, first.getOrDefault(curSum, 0) + 1);
            }
        }
        
        int ans = 0;
        for(int n3 : nums3) {
            for(int n4 : nums4) {
                curSum = -n3-n4;
                ans += first.getOrDefault(curSum, 0);
            }
        }
        return ans;
    }
}