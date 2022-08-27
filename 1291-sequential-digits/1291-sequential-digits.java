class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int lowDigit = getDigitLen(low);
        int highDigit = getDigitLen(high);

        int curAns, curDigit;
        for (int digitNum = lowDigit; digitNum <= highDigit; digitNum++) {
            for (int start = 1; start <= 10 - digitNum; start++) {
                curAns = 0;
                curDigit = start;
                for (int digit = 0; digit < digitNum; digit++) {
                    curAns = curAns * 10 + curDigit;
                    curDigit++;
                }
                
                if(curAns > high) break;
                if(curAns >= low) ans.add(curAns);
            }
        }
        return ans;
    }
    
    private int getDigitLen(int num) {
        int ret = 0;
        while (num != 0) {
            ret++;
            num /= 10;
        }
        return ret;
    }
}