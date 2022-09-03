class Solution {
    
    private int[] preorder;
    
    public boolean verifyPreorder(int[] preorder) {
        this.preorder = preorder;
        return recur(0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    
    private boolean recur(int start, int end, int lowerBound, int upperBound) {
        if(start > end) return true;
        
        int curVal = preorder[start];
        if(curVal <= lowerBound || curVal >= upperBound) return false;
        
        // [start+1, rightStart=1], [rightStart, end]
        int rightStart = start+1;
        
        // All the elements of preorder are unique.
        while(rightStart <= end && preorder[rightStart] < curVal) rightStart++;
        
        if(!recur(start+1, rightStart-1, lowerBound, curVal)) return false;
        if(!recur(rightStart, end, curVal, upperBound)) return false;
        return true;
    }
}