/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rowSize = binaryMatrix.dimensions().get(0);
        int colSize = binaryMatrix.dimensions().get(1);

        int ans = colSize;

        int left, right, mid, curVal;
        for (int i = 0; i < rowSize; i++) {
            left = 0;
            right = colSize - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                curVal = binaryMatrix.get(i, mid);
                if (curVal == 1) {
                    ans = Math.min(ans, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return ans == colSize ? -1 : ans;
    }
}