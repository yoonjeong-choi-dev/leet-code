class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        
        int ans = 0;
        int left, right;
        for(int n : nums) {
            // 이미 체크한 숫자는 무시
            if(!set.contains(n)) continue;
            
            set.remove(n);
            
            left = n-1;
            while(set.contains(left)) {
                set.remove(left--);
            }
            
            right = n+1;
            while(set.contains(right)) {
                set.remove(right++);
            }
            
            // cur sequence : [left+1, right-1] => len = right - left -1
            ans = Math.max(ans, right - left -1);
        }
        return ans;
    }
}