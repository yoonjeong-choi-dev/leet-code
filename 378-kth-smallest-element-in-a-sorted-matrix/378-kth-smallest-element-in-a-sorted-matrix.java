class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int numRows = matrix.length;
        int numCols = matrix.length;
        
        // (row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(matrix[o1[0]][o1[1]],matrix[o2[0]][o2[1]]);
            } 
        });
        
        for(int i=0;i<numRows;i++) pq.add(new int[] {i, 0});
        
        int[] curCell;
        while(true) {
            curCell = pq.poll();
            k--;
            
            if(k==0) {
                return matrix[curCell[0]][curCell[1]];
            }
            
            curCell[1]++;
            if(curCell[1] < numCols) pq.add(curCell);
        }
    }
}