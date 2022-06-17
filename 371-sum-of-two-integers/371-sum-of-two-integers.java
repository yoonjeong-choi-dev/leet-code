class Solution {
    public int getSum(int a, int b) {
        // Edge Case
        if(a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        
        // Assumption : |a| >= |b|
        // => 결과가 음수인지 양수인지 확인하기 위해
        int x = Math.abs(a), y = Math.abs(b);
        if(x < y) return getSum(b, a);
        
        // |a| >= |b| : a 가 양수인 경우에는 무조건 결과가 양수
        boolean isPlus = a > 0;
        
        
        if(a>0 ^ b>0) {
            // 빼기 연산 : |a| - |b|
            // XOR : 각 비트의 차이 => 각 비트에 대한 받애내림 무시한 뺄셈
            // 받아 내림 : |a| 비트는 0이고, |b| 비트는 1인 상황
            // => ~|a| 와 |b| 비트가 모두 1인 경우 i.e (~|a|) ^ |b|
            
            // 받아내림이 0이 될 때까지 뺄셈 연산
            int result, borrow;
            while(y!=0) {
                // 받아내림을 무시한 뺄셈 결과
                result = x ^ y;
                
                // 받아내림을 하기 위해 받아내림을 한 비트를 왼쪽으로 이동
                borrow = ((~x) & y) << 1;
                
                x = result;
                y = borrow;
            }
            
        } else {
            // 덧셈 연산 : |a| + |b|
            // XOR : 각 비트에 대한 carry 무시한 덧셈 => x 에 업데이트
            // AND : 각 비트에 대한 덧셈의 carry 여부 => y 에 업데이트
            
            // carry 가 0이 될 때까지 덧셈 연산
            int result, carry;
            while(y!=0) {
                // 받아올림 무시한 덧셈 결과
                result = x ^ y;
                
                // 받아올림을 위해 carry 비트를 왼쪽으로 1씩 이동
                carry = (x & y) << 1;
                
                x= result;
                y = carry;
            }
            
        }
        
        return isPlus ? x : -x;
    }
}