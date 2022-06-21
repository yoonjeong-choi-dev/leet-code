class Solution {
    
    private final Random random = new Random();
    private int[] nums;
    private int k;

    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length - k;
        
        int idx = quickSelect(0, nums.length-1);
        return nums[idx];
    }
    
    private int partition(int start, int end, int pivotIdx) {
        int pivotVal = nums[pivotIdx];
        
        // 우선 마지막에 피봇 옮기기
        swap(end, pivotIdx);
        
        // start -> end 탐색하면서 pivotVal 보다 작은 값들을 왼쪽으로 옮기기
        int left = start;
        for(int i=start;i<end;i++){
            if(nums[i] < pivotVal) {
                swap(left, i);
                left++;
            }
        }
        
        swap(left, end);
        return left;
    }
    
    private int quickSelect(int start, int end) {
        if(start == end) return start;
        
        int pivotIdx = start + random.nextInt(end-start);
        pivotIdx = partition(start, end, pivotIdx);
        
        if(pivotIdx == k) return pivotIdx;
        else if(pivotIdx > k) return quickSelect(start, pivotIdx-1);
        else return quickSelect(pivotIdx+1, end);
    }
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}