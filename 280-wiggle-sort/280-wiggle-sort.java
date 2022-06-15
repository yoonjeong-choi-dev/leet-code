class Solution {
    public void wiggleSort(int[] nums) {
        // 오름차 순으로 정렬
        Arrays.sort(nums);

        // 조건 : nums[0] <= nums[1] >= nums[2] <= nums[3]...
        // => swap(2i+1, 2i+2), i>=0
        int upperBound = nums.length - 1;
        int temp;
        for (int i = 1; i < upperBound; i += 2) {
            temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }
}