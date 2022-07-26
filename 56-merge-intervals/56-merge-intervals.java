class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2) {
               return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
           } 
        });
        
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int[] interval : intervals) {
            // 겹치는 경우 vs 안겹치는 경우
            if(interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                ans.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}