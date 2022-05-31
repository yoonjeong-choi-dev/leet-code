class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k;
        int len = s.length();

        // k 길이의 부분 문자열 저장 : k 비트로 구성된 문자열
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= len - k; i++) {
            String sub = s.substring(i, i + k);
            if (!set.contains(sub)) {
                set.add(sub);
                total--;
            }

            if (total == 0) return true;
        }

        return false;
    }
}