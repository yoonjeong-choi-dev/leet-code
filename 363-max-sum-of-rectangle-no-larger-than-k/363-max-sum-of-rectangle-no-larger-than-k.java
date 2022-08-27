class Solution {
    
    private int ans,target;
    private int[] partialSum;
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        
        ans = Integer.MIN_VALUE;
        target = k;
        
        // partialSum[j] : matrix[i:row][0:j] 합
        partialSum = new int[colSize];
        
        
        // matrix[i:][:] 부분 행렬에 대한 정답 찾기
        for(int i=0;i<rowSize;i++){
            Arrays.fill(partialSum, 0);
            
            // matrix[i:row] 누적으로 탐색
            for(int row=i;row<rowSize;row++){
                // partialSum for row-th row
                for(int col=0;col<colSize;col++) partialSum[col] += matrix[row][col];
                
                // matrix[i:row] 부분 행렬에 대해서 target 합이 있는지 확인
                findTarget();
                
                // 조기종료 
                if(ans == target) return ans;
            }
        }
        
        return ans;
    }
    
    private void findTarget() {
        int sum = 0;
        TreeSet<Integer> sorted = new TreeSet<>();
        sorted.add(0);
        
        // 1 차원 부분합 배열을 이용하여 특정 범위의 합을 찾는 과정
        // => target 이하의 합을 찾아야 함
        // i.e target = partial[i] - partial[j] for some j < i
        for(int num : partialSum) {
            sum += num;
            
            // target = sum - x  <=> x = sum - target
            Integer x = sorted.ceiling(sum - target);
            
            // update answer
            if(x!=null) ans = Math.max(ans, sum - x);
            
            sorted.add(sum);
        }
    }
}