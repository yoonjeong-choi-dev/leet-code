class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int len = s.length();
        
        // s and t consist of lowercase English letters.
        int[] occurs = new int[26];
        for(int i=0;i<len;i++){
            occurs[s.charAt(i)-'a']++;
            occurs[t.charAt(i)-'a']--;
        }
        
        for(int n : occurs) {
            if(n != 0) return false;
        }
        
        return true;
    }
}