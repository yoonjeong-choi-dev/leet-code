class Solution {
    public void wiggleSort(int[] nums) {
        // 조건 : nums[0] <= nums[1]
        boolean prevIncrease = false;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            // 이전 증가 방향가 같은 경우 swap
            // nums[i] vs nums[i+1] when nums[i-1] <= nums[i] : nums[i] < nums[i+1] => swap(nums[i], nums[i+1])
            if ((prevIncrease && nums[i - 1] < nums[i]) || (!prevIncrease && nums[i - 1] > nums[i])) {
                temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }

            // 이전 증가 방향과 반대로 설정
            prevIncrease = !prevIncrease;
        }
    }
}