class Vector2D {

        private int[][] vec;
        private int rowSize;
        private int row, col;

        public Vector2D(int[][] vec) {
            this.vec = vec;
            rowSize = vec.length;
            row = 0;
            while (row < rowSize && vec[row].length == 0) row++;
            col = 0;
        }

        public int next() {
            int ret = vec[row][col++];

            // 행을 바꿔야 하는 경우
            if (col == vec[row].length) {
                row++;
                while (row < rowSize && vec[row].length == 0) row++;
                col = 0;
            }

            return ret;
        }

        public boolean hasNext() {
            return row != rowSize;
        }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */