class Solution {
    public int connectSticks(int[] sticks) {
        // 가장 먼저 연결된 막대기들이 계속해서 비용에 더해짐
        // => 우선순위 큐를 이용해서 가장 길이가 짧은 2개의 막대기를 더함
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) pq.add(stick);

        int cost = 0;
        int curCost;
        while (pq.size() > 1) {
            curCost = pq.poll() + pq.poll();
            pq.add(curCost);
            cost += curCost;
        }

        return cost;
    }
}