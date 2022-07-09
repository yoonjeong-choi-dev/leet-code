class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;
        
        // [0, lastIdx] 까지는 도달 가능
        int lastIdx = nums[0];
        
        int curIdx = 0, prevLast;
        while(lastIdx < target) {
            prevLast = lastIdx;
            
            // 도달 가능한 마지막 인덱스 이전까지 요소들을 이용하여 도달 가능한 위치 업데이트
            while(curIdx <= prevLast) {
                lastIdx = Math.max(lastIdx, curIdx + nums[curIdx]);
                curIdx++;
            }
            
            // lastIdx 업데이트가 안되는 경우 => 이후 점프 불가능
            if(prevLast == lastIdx) return false;
        }
        
        // lastIdx >= target
        return true;
    }
}