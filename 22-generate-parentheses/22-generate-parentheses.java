class Solution {
    
    private List<String> ans;
    private int n, len;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        len = 2*n;
        ans = new ArrayList<>();
        
        boolean[] isLeft = new boolean[len];
        recur(0, 0, n, isLeft);
        
        return ans;
    }
    
    private void recur(int curIdx, int leftNum, int remainLeft, boolean[] isLeft) {
        // 왼쪽 괄호를 다쓴 경우
        if(remainLeft == 0) {
            StringBuilder sb = new StringBuilder(len);
            for(boolean left : isLeft) {
                if(left) sb.append('(');
                else sb.append(')');
            }
            
            ans.add(sb.toString());
            return;
        }
        
        if(curIdx + remainLeft*2 > len) return;
        
        // 왼쪽 괄호 추가
        isLeft[curIdx] = true;
        recur(curIdx+1, leftNum+1, remainLeft-1, isLeft);
        isLeft[curIdx] = false;
        
        // 오른쪽 괄호 추가
        if(leftNum > 0) {
            recur(curIdx+1, leftNum-1, remainLeft, isLeft);
        }
    }
}