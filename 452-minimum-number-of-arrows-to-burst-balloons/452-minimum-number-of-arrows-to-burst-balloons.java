class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<>() {
           public int compare(int[] p1, int[] p2) {
               if(p1[0] != p2[0]) return Integer.compare(p1[0], p2[0]);
               else return Integer.compare(p1[1], p2[1]);
           } 
        });
        
        int ans = 1;
        
        // 시작점에 대해서 오름차순으로 정렬하였으므로, 끝점만 필요
        int curEnd = points[0][1];
        for(int[] p : points) {
            if(curEnd < p[0]) {
                curEnd = p[1];
                ans++;
            } else {
                curEnd = Math.min(p[1], curEnd);
            }
        }
        return ans;
    }
}