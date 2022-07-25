class Solution {
    public String parseTernary(String expression) {
        Stack<Integer> stack = new Stack<>();

        char curChar;
        int curExpressionIdx;
        for (int i = expression.length() - 1; i >= 0; i--) {
            // check T? vs F?
            curChar = expression.charAt(i);
            if (curChar == '?') {
                i--;
                if (expression.charAt(i) == 'T') {
                    // 앞에 표현식 사용
                    curExpressionIdx = stack.pop();
                    stack.pop();
                    stack.push(curExpressionIdx);
                } else {
                    stack.pop();
                }
            } else if (curChar != ':') stack.push(i);
        }

        return String.valueOf(expression.charAt(stack.pop()));
    }
}