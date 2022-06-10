class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if (len == 0) return 0;

        // 윈도우에서 해당 문자의 가장 왼쪽 인덱스 저장
        int[] leftCharAt = new int[128];
        Arrays.fill(leftCharAt, -1);

        // 정답은 최소 1
        int ans = 1;
        int curWindowLeft = 0;

        char curChar;
        for (int i = 0; i < len; i++) {
            // i번째 문자 추가
            curChar = s.charAt(i);

            // 현재 윈도우에 현재 문자가 있는 경우
            if (leftCharAt[curChar] != -1 && leftCharAt[curChar] >= curWindowLeft) {
                // i번째 문자 추가전에 현재 윈도우 길이 계산
                ans = Math.max(ans, i - curWindowLeft);

                curWindowLeft = leftCharAt[curChar] + 1;
            }

            // 현재 문자 정보 저장
            leftCharAt[curChar] = i;
        }

        // 마지막 윈도우 계산
        ans = Math.max(ans, len - curWindowLeft);

        return ans;
    }
}