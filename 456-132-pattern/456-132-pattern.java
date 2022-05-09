class Solution {
    public boolean find132pattern(int[] nums) {
        int size = nums.length;
        if (size < 3) return false;

        // 패턴 1 후보 숫자들
        // min[i] : nums[0:i] 중 최소값
        int[] min = new int[size];
        min[0] = nums[0];
        for (int i = 1; i < size; i++) min[i] = Math.min(min[i - 1], nums[i]);

        // 패턴 2 후보 숫자들
        Stack<Integer> stack = new Stack<>();

        int pattern3;
        for (int i = size - 1; i >= 1; i--) {
            // nums[i] : 패턴 3 후보 숫자
            if(min[i] >= nums[i]) {
                // 패턴 1보다 작거나 같으면 패턴3&2 후보로 불가능
                continue;
            }
            
            pattern3 = nums[i];
            
            // 패턴 2 후보 중에 패턴 1보다 작거나 같은 숫자들 제거
            while(!stack.isEmpty() && stack.peek() <= min[i]) stack.pop();
            
            if(!stack.isEmpty() && stack.peek() < pattern3) return true;
            
            
            // 현재 숫자를 패턴 2 후보로 저장
            stack.push(pattern3);
        }

        return false;
    }
}