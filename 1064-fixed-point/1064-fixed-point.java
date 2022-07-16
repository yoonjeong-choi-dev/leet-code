class Solution {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        int mid;
        int ans = -1;
        while (left <= right) {
            mid = (left + right) / 2;


            if (arr[mid] == mid) {
                // return the smallest index => 왼쪽에서 더 찾아봐야 함
                ans = mid;
                right = mid - 1;
            } else if (mid > arr[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return ans;
    }
}