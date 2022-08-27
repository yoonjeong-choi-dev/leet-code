class Solution {
    public long numberOfWays(String s) {
        int len = s.length();

        // 0 과 1 길이 저장
        List<Integer> nums = new ArrayList<>();
        int idx = 0, start;
        char cur;
        while (idx < len) {
            start = idx;
            cur = s.charAt(idx);
            while (idx < len && s.charAt(idx) == cur) {
                idx++;
            }
            nums.add(idx - start);
        }

        if (nums.size() < 3) return 0L;

        long ans = 0L;

        // 현재 인덱스 전 인덱스(i)의 홀/짝에 대한 정보
        // nums[:i] 에 대해서 2개를 선택할 수 있는 경우의 수
        long oddIdxSum = (long) nums.get(0) * nums.get(1), evenIdxSum = 0L;
        long numOdd = nums.get(1), numEven = nums.get(0);

        boolean isEvenIdx = true;
        int curNum;
        for (int i = 2; i < nums.size(); i++) {
            curNum = nums.get(i);
            if (isEvenIdx) {
                ans += oddIdxSum * curNum;

                // i 에 대한 정보 업데이트
                evenIdxSum = evenIdxSum + numOdd * curNum;
                numEven += curNum;
            } else {
                ans += evenIdxSum * curNum;

                // i 에 대한 정보 업데이트
                oddIdxSum = oddIdxSum + numEven * curNum;
                numOdd += curNum;
            }

            isEvenIdx = !isEvenIdx;
        }

        return ans;
    }
}