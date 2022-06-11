class Solution {
    public int minSwaps(int[] data) {
        int numOnes = 0;
        for (int d : data) {
            if (d == 1) numOnes++;
        }

        if (numOnes <= 1 || numOnes == data.length) return 0;

        // numOnes 길이의 윈도우에 가장 많은 1이 들어 있어야 함
        // => 나머지 0들을 윈도우 밖의 1과 교환
        int curZeros = 0;
        for (int i = 0; i < numOnes; i++) {
            if (data[i] == 0) curZeros++;
        }

        int ans = curZeros;
        for (int i = numOnes; i < data.length; i++) {
            // i 추가, i-numOnes 제거
            if (data[i - numOnes] == 0) curZeros--;
            if (data[i] == 0) curZeros++;

            ans = Math.min(ans, curZeros);
        }

        return ans;
    }
}