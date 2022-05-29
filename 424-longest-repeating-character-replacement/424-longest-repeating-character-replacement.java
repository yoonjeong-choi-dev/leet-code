class Solution {
    public int characterReplacement(String s, int k) {
        int ans = k;
        int[] occurMap = new int[26];

        int len = s.length();
        int left = 0, right = 0;
        while (right < len) {
            occurMap[s.charAt(right) - 'A']++;
            right++;

            while ((right - left - getMaxElem(occurMap)) > k) {
                occurMap[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    private int getMaxElem(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}