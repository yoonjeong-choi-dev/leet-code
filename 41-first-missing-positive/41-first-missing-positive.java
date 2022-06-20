class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        final int NULL_VAL = len + 1;
        
        // smallest missing positive integer
        // => 음수 및 현재 길이보다 큰 숫자들은 신경쓰지 않는다
        for(int i=0;i<len;i++){
            if(nums[i] <= 0 || nums[i] > len) nums[i] = NULL_VAL;
        }
        
        // expected : nums[i] = i+1
        // => nums[i] < 0 : i+1 존재
        int curIdx, curVal;
        for(int i=0;i<len;i++){
            curVal = Math.abs(nums[i]);
            
            // 불필요한 데이터인 경우 무시
            if(curVal == NULL_VAL) continue;
            
            curIdx = curVal - 1;
            if(nums[curIdx] > 0) nums[curIdx] *= -1;
        }
        
        // 1 ~ len 까지 중에 없는 숫자 반환
        // nums[i] >= 0 => return i+1
        for(int i=0;i<len;i++){
            if(nums[i] > 0) return i+1;
        }
        
        // 1 ~len 까지 모두 존재
        return len+1;
    }
}