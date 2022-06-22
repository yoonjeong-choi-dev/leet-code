class Solution {
    public int[][] merge(int[][] intervals) {
        // 시작점 순서로 정렬
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            }
        });
        
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            // 현재 범위와 겹치지 않는 경우
            if(intervals[i][0] > end) {
                ans.add(new int[] {start, end});
                
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        
        // 마지막 처리
        ans.add(new int[] {start, end});
        
        return ans.toArray(new int[ans.size()][2]);
    }
}