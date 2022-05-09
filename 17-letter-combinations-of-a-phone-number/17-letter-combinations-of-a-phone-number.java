class Solution {
    static final Map<Character, String> numToChar = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    private String digits;
    private List<String> ans;
    char[] path;
    private int len;

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        this.digits = digits;
        len = digits.length();

        int totalSize = 1;
        for (int i = 0; i < len; i++) {
            totalSize *= numToChar.get(digits.charAt(i)).length();
        }

        ans = new ArrayList<>(totalSize);
        path = new char[len];

        recursive(0);

        return ans;
    }

    private void recursive(int curIdx) {
        if (curIdx == len) {
            ans.add(new String(path));
            return;
        }

        String curStrs = numToChar.get(digits.charAt(curIdx));
        for (int i = 0; i < curStrs.length(); i++) {
            path[curIdx] = curStrs.charAt(i);
            recursive(curIdx+1);
        }
    }
}