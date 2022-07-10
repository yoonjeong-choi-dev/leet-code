class Solution {
    
    private int[] nums1, nums2;
    private int len1, len2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        len1 = nums1.length;
        this.nums2 = nums2;
        len2 = nums2.length;
        
        int totalLen = len1 + len2;
        
        // 2n -> n 및 n+1 번째
        // 2n+1 -> n+1, n+1 번째
        int leftTarget = (totalLen + 1) / 2;
        int rightTarget = (totalLen + 2) / 2;
        
        return (getKthValue(0, 0, leftTarget) + getKthValue(0,0, rightTarget)) / 2.0;
    }
    
    // nums1[idx1:], nums2[idx2:] 부분 배열에 대한 
    private double getKthValue(int idx1, int idx2, int k) {
        // Edge Case : 두 배열 중 하나가 끝까지 간 경우
        if(idx1 >= len1) return nums2[idx2 + k - 1];
        if(idx2 >= len2) return nums1[idx1 + k - 1];
        
        // 현재 부분 배열의 첫번째 요소
        if(k==1) return Math.min(nums1[idx1], nums2[idx2]);
        
        // 두 배열 쪼개기
        int mid = k/2;
        int midVal1 = Integer.MAX_VALUE, midVal2 = Integer.MAX_VALUE;
        
        if(idx1 + mid - 1 < len1) midVal1 = nums1[idx1 + mid-1];
        if(idx2 + mid - 1 < len2) midVal2 = nums2[idx2 + mid-1];
        
        if(midVal1 < midVal2) {
            // nums1.right + nums2
            // => nums1 에서 k/2 만큼 제거
            return getKthValue(idx1 + mid, idx2, k - mid);
        } else {
            // nums1 + nums2.right
            // => nums2 에서 k/2 만큼 제거
            return getKthValue(idx1, idx2 + mid, k - mid);
        }
    }
}