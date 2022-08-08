class Solution {
    // 2[a]2[b2[cd]]ef
    // => ans : aa bcdcd bcdcd ef
    
    public String decodeString(String s) {
        StringBuilder curAns = new StringBuilder();
        
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int curNum = 0;
        
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                curNum = curNum*10 + c - '0';
            } else if(c == '[') {
                // 반복할 숫자 저장
                // 2[ : (2), ("")
                // 2[a]2[ : (2), ("aa")
                // 2[a]2[b2[ : (2,2), ("aa", "b")
                countStack.push(curNum);
                curNum = 0;
                
                // 현재까지 만들어진 문자열 저장
                sbStack.push(curAns);
                curAns = new StringBuilder();
            } else if( c == ']') {
                // [] 사이에 만들어진 문자열을 정답에 저장해야 함
                // 2[a] : prevAns = "", curAns = "a" => curAns = "aa"
                // 2[a]2[b2[cd] : (2,2), ("aa", "b") => prevAns = "b", curAns = "cd"
                // => (2), ("aa"), curAns = bcdcd
                // 2[a]2[b2[cd]] : (2), ("aa") => prevAns = ("aa") curAns = bcdcd
                // => (),(), curAns = "aabcdcdbcdcd"
                StringBuilder prevAns = sbStack.pop();
                for(int i=countStack.pop();i>0;i--) {
                    prevAns.append(curAns);
                }
                
                curAns = prevAns;
            } else {
                // 현재 만들어지고 있는 문자열
                // 2[a : curAns - "a"
                // 2[a]2[b : curAns - "b"
                // 2[a]2[b2[cd - curAns = "cd"
                // 2[a]2[b2[cd]]ef - curAns = aabcdcdbcdcdef
                curAns.append(c);
            }
        }
        
        
        return curAns.toString();
    }
}