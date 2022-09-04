class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        
        int copy, digit;
        for (int num = left; num <= right; num++) {
            copy = num;
            while(copy != 0) {
                digit = copy % 10;
                if(digit == 0 || num % digit != 0) break;
                copy /= 10;
            }
            
            if(copy == 0) ans.add(num);
        }
        return ans;
    }
}