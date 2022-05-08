class Solution {
    public int findDuplicate(int[] nums) {
        // nums[nums[i]] <- -1 * nums[nums[i]] : nums에 nums[i] 가 있는 경우
        // => nums[i] <0 : i 가 nums 배열에 존재
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i] > 0 ? nums[i] : -nums[i];
            if (nums[num] < 0) {
                // num 을 이미 방문한 경우
                return num;
            }

            nums[num] = -nums[num];
        }

        // never reach
        return -1;
    }
}