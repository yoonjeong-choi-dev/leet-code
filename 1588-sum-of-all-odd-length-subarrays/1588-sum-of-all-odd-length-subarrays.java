class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int size = arr.length;
        int[] partialSum = new int[size+1];
        for(int i=0;i<size;i++) partialSum[i+1] = partialSum[i] + arr[i];
        
        int ans = 0;
        for(int start=0;start<size;start++){
            for(int end=start+1;end<=size;end+=2){
                ans += partialSum[end] - partialSum[start];
            }
        }
        return ans;
    }
}