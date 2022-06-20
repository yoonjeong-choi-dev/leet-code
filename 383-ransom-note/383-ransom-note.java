class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        
        
        // ransomNote and magazine consist of lowercase English letters
        int[] occurs = new int[26];
        
        // 우선 magazine 문자 정보 저장
        for(char c : magazine.toCharArray()) occurs[c-'a']++;
        
        // 만들어야 하는 ransomeNote 문자 정보를 뺀다
        // 뺄 수 없으면 false
        int charToIdx;
        
        for(char c : ransomNote.toCharArray()) {
            charToIdx = c-'a';
            occurs[charToIdx]--;
            
            if(occurs[charToIdx] < 0) return false;
        }
        
        return true;
    }
}