class Solution {
    public int maxLength(List<String> arr) {
        Set<Integer> candidates = new HashSet<>();
        candidates.add(0);

        int ans = 0;
        int wordToBits, curBit, createdLen, createdBits;
        boolean isUnique;
        Set<Integer> nextCandidates = new HashSet<>();
        for (String word : arr) {

            // Step 1: convert the word to 26-bits array
            wordToBits = 0;
            isUnique = true;
            for (char c : word.toCharArray()) {
                curBit = 1 << (c - 'a');

                // 현재 단어에 중복된 문자가 있는 경우는 후보군에서 제외
                if ((wordToBits & curBit) > 0) {
                    isUnique = false;
                    break;
                }

                wordToBits += curBit;
            }

            // 이미 해당 단어가 존재하는 경우 무시
            if (!isUnique || candidates.contains(wordToBits)) continue;

            // 현재까지 만들어진 후보 군에 붙일 수 있는지 여부 확인
            nextCandidates.clear();
            for (int candidate : candidates) {
                if ((candidate & wordToBits) > 0) continue;

                // 붙일 수 있는 경우, 붙였을 때의 길이와 비트 배열 저장
                createdLen = (candidate >> 26) + word.length();
                createdBits = (candidate + wordToBits) & ((1 << 26) - 1);
                
                // 문자열 길이 정보를 26 비트 이후 부분에 저장 => (candidate >> 26) 연산을 통해 문자열 길이 가져 올 수 있음
                nextCandidates.add((createdLen << 26) + createdBits);
                ans = Math.max(ans, createdLen);
            }
        

            candidates.addAll(nextCandidates);
        }
        return ans;
    }
}