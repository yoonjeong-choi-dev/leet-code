class Solution {
    public int maxLength(List<String> arr) {
        List<String> candidates = new ArrayList<>();
        candidates.add("");

        int ans = 0;
        Set<Character> composite = new HashSet<>();
        boolean isDisjoint;
        for (String word : arr) {
            composite.clear();
            for (char c : word.toCharArray()) composite.add(c);

            // 현재 단어에 중복된 문자가 있는 경우는 후보군에서 제외
            if (composite.size() != word.length()) continue;

            // 현재까지 만들어진 후보 군에 붙일 수 있는지 여부 확인
            for (int i = 0; i < candidates.size(); i++) {
                String candidate = candidates.get(i);
                isDisjoint = true;
                for (char c : candidate.toCharArray()) {
                    if (composite.contains(c)) {
                        isDisjoint = false;
                        break;
                    }
                }

                if (isDisjoint) {
                    candidates.add(candidate + word);
                    ans = Math.max(ans, word.length() + candidate.length());
                }
            }
        }
        
        return ans;
    }
}