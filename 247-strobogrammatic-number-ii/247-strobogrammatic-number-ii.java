class Solution {
    
    // 0, 1, 6, 8, 9
    private static final Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};
    
    private static final char[] reversible = {'0', '1', '6', '8', '9'};
    private static final char[] onlyMid = {'0', '1', '8'};
    
    private List<String> ans;
    private boolean isOdd;
    private int testLen, lastIdx;
    
    public List<String> findStrobogrammatic(int n) {
        testLen = n / 2;
        isOdd = (n%2) == 1;
        lastIdx = n-1;
        
        ans = new ArrayList<>();
        
        char[] path = new char[n];
        recur(0, path);
        
        return ans;
    }
    
    private void recur(int curIdx, char[] path) {
        if(curIdx == testLen) {
            if(isOdd) {
                for(char c : onlyMid) {
                    path[curIdx] = c;
                    ans.add(String.valueOf(path));
                }
                
            } else {
                ans.add(String.valueOf(path));
            }
            
            return;
        }
        
        
        // 첫 시작은 0 불가능
        int startIdx = curIdx == 0 ? 1 : 0;
        
        char c;
        for (int i=startIdx; i<reversible.length;i++){
            c = reversible[i];
            path[curIdx] = c;
            path[lastIdx-curIdx] = map.get(c);
            
            recur(curIdx+1, path);
        }
        
    }
}