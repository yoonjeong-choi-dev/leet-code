class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        final char sep = '#';
        
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String s : strs) {
            // strs[i] consists of lowercase English letters
            int[] occurs = new int[26];
            for(char c : s.toCharArray()) {
                occurs[c-'a']++;
            }
            
            // generate key w.r.t char occurence
            StringBuilder sb = new StringBuilder();
            for(int i : occurs) {
                sb.append(i).append(sep);
            }
            
            String key = sb.toString();
            
            // save
            if(!anagrams.containsKey(key)) anagrams.put(key, new ArrayList<>());
            anagrams.get(key).add(s);
        }
        
        
        List<List<String>> ans = new ArrayList<>();
        List<String> curAns;
        for(String key : anagrams.keySet()) {
            curAns = new ArrayList<>();
            for(String s : anagrams.get(key)) {
                curAns.add(s);
            }
            ans.add(curAns);
        }
        return ans;
    }
}