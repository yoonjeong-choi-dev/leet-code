class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> occurs = new HashMap<>();
        for(String word : words) occurs.put(word, occurs.getOrDefault(word, 0) + 1);
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
           public int compare(String s1, String s2) {
               if(occurs.get(s1) != occurs.get(s2)) {
                   return occurs.get(s1) - occurs.get(s2);
               } else {
                   return s2.compareTo(s1);
               }
           } 
        });
        
        for(String key : occurs.keySet()) {
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }
        
        LinkedList<String> ans = new LinkedList<>();
        while(!pq.isEmpty()) ans.addFirst(pq.poll());
        
        return ans;
    }
}