class Solution {
    private final Random random = new Random();
    private int[] dist;
    private int[] idx;
    private int k;

    public int[][] kClosest(int[][] points, int k) {
        int nums = points.length;
        dist = new int[nums];
        idx = new int[nums];
        this.k = k;

        for (int i = 0; i < nums; i++) {
            idx[i] = i;
            dist[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

        quickSelect(0, nums - 1);

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[idx[i]];
        }
        return ans;
    }

    private void quickSelect(int start, int end) {
        if (start == end) return;

        int pivotIdx = start + random.nextInt(end - start);
        pivotIdx = partition(start, end, pivotIdx);
        if (pivotIdx == k) return;
        else if (pivotIdx > k) quickSelect(start, pivotIdx - 1);
        else quickSelect(pivotIdx + 1, end);
    }

    private int partition(int start, int end, int pivotIdx) {
        int pivotVal = dist[idx[pivotIdx]];
        
        // 우선 피봇값을 오른쪽으로 이동
        swap(end, pivotIdx);
        
        // 피봇값보다 작은 것들 왼쪽 이동
        int left = start;
        for(int i=start;i<end;i++){
            if(dist[idx[i]] < pivotVal) {
                swap(i, left);
                left++;
            }
        }
        
        // 피봇 위치 변경
        swap(left, end);
        return left;
    }

    private void swap(int i, int j) {
        int temp = idx[i];
        idx[i] = idx[j];
        idx[j] = temp;
    }
}