class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> counter = new Stack<>();
        
        int num = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num*10 + c-'0';
            } else if(c == '[') {
                counter.push(num);
                num = 0;
                
                sbStack.push(ans);
                ans = new StringBuilder();
            } else if(c == ']') {
                StringBuilder cur = sbStack.pop();
                for(int i=counter.pop();i>0;i--) cur.append(ans);
                
                ans = cur;
            } else {
                ans.append(c);
            }
        }
        
        return ans.toString();
    }
}