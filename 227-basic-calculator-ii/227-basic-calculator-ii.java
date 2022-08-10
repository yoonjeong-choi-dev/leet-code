class Solution {
    public int calculate(String s) {
        int len = s.length();
        
        // 덧셈을 할 숫자들만 넣는다
        Stack<Integer> plusStack = new Stack<Integer>();
        int number = 0;
        char operation = '+', cur;
        
        for(int i=0;i<len;i++){
            cur = s.charAt(i);
            
            if(Character.isDigit(cur)) {
                number = number*10 + cur - '0';
            } 
            
            if(!Character.isDigit(cur) && !Character.isWhitespace(cur) || i == len-1) {
                if(operation == '+') plusStack.push(number);
                else if(operation == '-') plusStack.push(-number);
                else if(operation == '*') plusStack.push(plusStack.pop() * number);
                else if(operation == '/') plusStack.push(plusStack.pop() / number);
                
                number = 0;
                operation = cur;
            }
        }
        
        int ans = 0;
        while(!plusStack.isEmpty()) ans += plusStack.pop();
        return ans;
    }
}