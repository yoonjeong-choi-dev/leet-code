class Solution {
    public void rotate(int[][] matrix) {
        int start = 0, end, prev;

        int curWindowSize = matrix.length;
        while (curWindowSize > 1) {
            end = start + curWindowSize - 1;

            for (int i = 0; i < curWindowSize - 1; i++) {
                // update : top -> left -> bottom -> right 
                prev = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = prev;
            }
            
            start++;
            curWindowSize -= 2;
        }
    }
}