class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counters = new HashMap<>();
        for(String word : words) counters.put(word, counters.getOrDefault(word, 0) + 1);
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(String s1, String s2) {
                if(counters.get(s1) == counters.get(s2)) {
                    return s2.compareTo(s1);
                } else {
                    return counters.get(s1) - counters.get(s2);
                }
            }
        });
        
        for(String key : counters.keySet()) {
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }
        
        LinkedList<String> ans = new LinkedList<>();
        while(!pq.isEmpty()) ans.addFirst(pq.poll());
        return ans;
    }
}