class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();
        
        StringBuilder curAns;
        int curNum = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                curNum = curNum*10 + c- '0';
            } else if(c == '[') {
                // 현재까지 저장한 문자열 및 숫자 저장
                strStack.push(ans);
                counterStack.push(curNum);
                
                // 문자열 및 숫자 초기화
                ans = new StringBuilder();
                curNum = 0;
            } else if(c == ']') {
                // 이전에 만든 문자열에 현재까지 만든 문자(괄호 안에 있는 문자열) 반복해서 추가
                curAns = strStack.pop();
                for(int i=counterStack.pop();i>0;i--) curAns.append(ans);
                
                ans = curAns;
            } else {
                ans.append(c);
            }
        }
        
        return ans.toString();
    }
}