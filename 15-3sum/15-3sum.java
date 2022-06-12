class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        List<List<Integer>> ans = new LinkedList<>();

        int left, right, curTarget, curSum;
        for (int first = 0; first < len - 2; first++) {
            // 중복제거를 위해 첫 요소가 다른 경우에만 탐색
            if (first != 0 && nums[first] == nums[first - 1]) continue;

            // second 및 third 에 대한 2Sum 문제
            curTarget = -nums[first];
            left = first + 1;
            right = len - 1;
            while (left < right) {
                curSum = nums[left] + nums[right];
                if (curSum < curTarget) {
                    // 현재 합이 작으므로 왼쪽 인덱스 이동
                    left++;
                } else if (curSum > curTarget) {
                    // 현재 합이 크므로 오른쪽 인덱스 이동
                    right--;
                } else {
                    // 현재 정답 저장 및 left,right 이동
                    ans.add(Arrays.asList(nums[first], nums[left++], nums[right--]));

                    // left 및 right 값이 달라질 때 까지 이동
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right + 1] == nums[right]) right--;
                }
            }
        }
        
        return ans;
    }
}