class Solution {
    public int minSwaps(int[] data) {
        int len = data.length;
        int numOnes = 0;
        for(int n : data) {
            if(n == 1) numOnes++;
        }
        
        if(numOnes < 2 || numOnes == len) return 0;
        
        int curZeros = 0;
        for(int i=0;i<numOnes;i++){
            if(data[i] == 0) curZeros++;
        }
        
        int ans = curZeros;
        for(int i=numOnes;i<len;i++){
            if(data[i] == 0) curZeros++;
            if(data[i-numOnes] == 0) curZeros--;
            
            ans = Math.min(ans, curZeros);
        }
        return ans;
    }
}