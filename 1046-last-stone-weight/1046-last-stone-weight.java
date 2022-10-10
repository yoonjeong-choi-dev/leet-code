class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int stone : stones) pq.add(stone);
        
        int stone1, stone2;
        while(pq.size() > 1) {
            stone1 = pq.poll();
            stone2 = pq.poll();
            if(stone1 != stone2) pq.add(stone1 - stone2);
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}