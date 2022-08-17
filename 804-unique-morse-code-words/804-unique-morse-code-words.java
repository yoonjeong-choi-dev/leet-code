class Solution {
    private static final String[] morse 
            = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> convertedSet = new HashSet<>();
        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()) sb.append(morse[c-'a']);
            convertedSet.add(sb.toString());
        }
        
        return convertedSet.size();
    }
}