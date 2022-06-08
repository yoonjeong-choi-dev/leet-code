class Solution {
    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;

        boolean[] rowFlag = new boolean[rowSize];
        boolean[] colFlag = new boolean[colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            if (rowFlag[i]) {
                for (int j = 0; j < colSize; j++) matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < colSize; j++) {
            if (colFlag[j]) {
                for (int i = 0; i < rowSize; i++) matrix[i][j] = 0;
            }
        }
    }
}