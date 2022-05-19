class Solution {
    private List<Set<Integer>> row, col, square;
    private char[][] board;
    private boolean isSolved;

    public void solveSudoku(char[][] board) {
        this.board = board;
        isSolved = false;

        row = new ArrayList<>(9);
        col = new ArrayList<>(9);
        square = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            square.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int curNum = board[i][j] - '0';
                    row.get(i).add(curNum);
                    col.get(j).add(curNum);
                    square.get(getSquareIndex(i, j)).add(curNum);
                }
            }
        }
        
        dfs(0);
    }

    private void dfs(int curIdx) {

        if (curIdx == 81) {
            isSolved = true;
            return;
        }

        int x = curIdx / 9;
        int y = curIdx % 9;

        if (board[x][y] != '.') {
            dfs(curIdx + 1);
        } else {
            int sq = getSquareIndex(x, y);

            for (int i = 1; i < 10; i++) {
                if (!row.get(x).contains(i) && !col.get(y).contains(i) && !square.get(sq).contains(i)) {
                    board[x][y] = (char) (i + '0');
                    row.get(x).add(i);
                    col.get(y).add(i);
                    square.get(sq).add(i);
                    dfs(curIdx + 1);

                    if (isSolved) return;
                    else {
                        board[x][y] = '.';
                        row.get(x).remove(i);
                        col.get(y).remove(i);
                        square.get(sq).remove(i);
                    }
                }
            }
        }
    }

    private int getSquareIndex(int x, int y) {
        return (x / 3) * 3 + y / 3;
    }
}