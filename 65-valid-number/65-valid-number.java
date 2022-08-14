class Solution {
    public boolean isNumber(String s) {
        // Rule 1 : . 및 e/E 은 최대 1번
        boolean seenDot = false;
        boolean seenE = false;
        
        // . 및 e/E 추적을 위해 직전이 숫자였는지 확인
        boolean isDigit = false;
        
        char cur;
        for(int i=0;i<s.length();i++) {
            cur = s.charAt(i);
            
            if(Character.isDigit(cur)) {
                isDigit = true;
            } else if(cur == '+' || cur == '-') {
                // 맨 앞이나 e/E 바로 이후에만 존재 가능
                if(i>0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
                
            } else if(cur == 'E' || cur == 'e') {
                //  An 'e' or 'E', followed by an integer
                if(seenE || !isDigit) return false;
                
                seenE = true;
                
                // e/E 이후에는 숫자가 반드시 와야하므로 숫자 플래그 초기화
                isDigit = false;
            } else if(cur == '.') {
                // A dot '.', followed by one or more digits
                // An 'e' or 'E', followed by an integer.
                if(seenDot || seenE) return false;
                
                seenDot = true;
                
            } else {
                return false;
            }
        }
        
        // 숫자를 본 경우에만 true
        return isDigit;
    }
}