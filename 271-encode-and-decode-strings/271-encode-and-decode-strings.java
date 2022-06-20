public class Codec {

        private static final char LEN_INFO_SEP = '#';

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            // 문자열 길이 정보의 길이 + "#" + 단어
            StringBuilder ans = new StringBuilder();
            String lenInfo;

            for (String s : strs) {
                lenInfo = String.valueOf(s.length());
                ans.append(lenInfo.length()).append(LEN_INFO_SEP).append(lenInfo).append(s);
            }

            return ans.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ans = new ArrayList<>();

            int len = s.length();
            int idx = 0;

            StringBuilder lenInfoBuffer;
            int wordLen, wordLenInfoLen;
            while (idx < len) {
                lenInfoBuffer = new StringBuilder();
                while (s.charAt(idx) != LEN_INFO_SEP) lenInfoBuffer.append(s.charAt(idx++));
                idx++;

                // 문자열 길이 정보의 길이
                wordLenInfoLen = Integer.parseInt(lenInfoBuffer.toString());
                // 문자열 길이 정보
                wordLen = Integer.parseInt(s.substring(idx, idx + wordLenInfoLen));

                // 실제 문자
                idx += wordLenInfoLen;
                ans.add(s.substring(idx, idx + wordLen));

                idx += wordLen;
            }
            
            return ans;
        }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));