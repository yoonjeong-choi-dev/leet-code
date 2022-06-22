class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        
        int ans = 0;
        
        // [start, end] 범위와 겹치는 범위들 추적
        int curOverlapped = 0;
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            if(end <= intervals[i][0]) {
                // 새로운 범위 시작
                start = intervals[i][0];
                end = intervals[i][1];
                ans += curOverlapped;
                curOverlapped = 0;
            } else {
                // curEnd < end 
                // 정렬 규칙에 의해서 start < curStart < curEnd < end
                start = Math.max(start, intervals[i][0]);
                end = Math.min(end, intervals[i][1]);
                curOverlapped++;
            }
        }
        
        ans += curOverlapped;
        return ans;
    }
}