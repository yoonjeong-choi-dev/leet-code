/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int ans = n;
        
        int mid;
        boolean result;
        
        while(left <= right) {
            mid = left + (right - left) /2;
            result = isBadVersion(mid);
            
            if(result) {
                ans = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        
        return ans;
    }
}