class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();

        // 가장 긴 시작 회문의 부분 문자열 찾기 : [0, lastMatch]
        // => 뒤에서부터 시작하여 일치하는 문자들
        int lastMatch = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(lastMatch)) {
                lastMatch++;
            }
        }

        // 회문인 경우 바로 리턴
        if (lastMatch == len) return s;

        // [lastMatch, len-1] 까지 뒤집어 준다
        String reverse = new StringBuilder(s.substring(lastMatch)).reverse().toString();

        return reverse + shortestPalindrome(s.substring(0, lastMatch)) + s.substring(lastMatch);
    }
}