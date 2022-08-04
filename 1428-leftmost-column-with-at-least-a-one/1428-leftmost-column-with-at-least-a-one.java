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

        int curRow = 0, curCol = colSize - 1;

        while (curRow < rowSize && curCol >= 0) {
            if (binaryMatrix.get(curRow, curCol) == 0) {
                // each row of the matrix is sorted in non-decreasing order
                // => 오른쪽부분은 모두 0 => 다음 행 조사
                curRow++;
            } else {
                // curCol 이 현재 정답 => 최소값을 찾기 위해 이전 열 조사
                curCol--;
            }
        }

        return curCol == colSize - 1 ? -1 : curCol + 1;
    }
}