class Solution {
    public String stringShift(String s, int[][] shift) {
        int numRight = 0;
        for(int[] move : shift) {
            numRight += move[0] == 1 ? -move[1] : move[1];
        }
        
        int len = s.length();
        while(numRight < 0) numRight += len;
        numRight = numRight % len;
        
        // [numRight,len-1] + [0, numRight-1]
        return s.substring(numRight, len) + s.substring(0, numRight);
    }
}