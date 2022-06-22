class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 시작 시간이 빠른 순서로 정렬
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               return a[0] - b[0];
           } 
        });
        
        // 먼저 끝나는 구간의 인덱스가 top 으로
        PriorityQueue<Integer> reserved = new PriorityQueue<>(new Comparator<Integer>(){
           public int compare(Integer a, Integer b){
               return intervals[a][1] - intervals[b][1];
           } 
        });
        
        
        int ans = 1;
        
        int len = intervals.length;
        int[] cur;
        for(int i=0;i<len;i++){
            cur = intervals[i];
            
            // 현재 시작 시간보다 일찍 끝나는 구간들 정리
            while(!reserved.isEmpty() && intervals[reserved.peek()][1] <= cur[0]) reserved.poll();
            
            // 현재 구간 예약
            reserved.add(i);
            
            ans = Math.max(ans, reserved.size());
        }
        
        return ans;
    }
}