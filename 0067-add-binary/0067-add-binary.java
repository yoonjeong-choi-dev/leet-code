class Solution {
    public String addBinary(String a, String b) {
        if(a.length() > b.length()) return addBinary(b, a);
        
        int idx1= a.length()-1, idx2=b.length()-1;
        StringBuilder ans= new StringBuilder();
        
        int carry=0,sum;
        while(idx1>=0) {
            sum = carry;
            sum += a.charAt(idx1--)-'0' + b.charAt(idx2--)-'0';
            
            if(sum >=2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            
            ans.insert(0, sum);
        }
        
        while(idx2 >= 0) {
            sum = carry + b.charAt(idx2--) -'0';
            if(sum >=2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            
            ans.insert(0, sum);
        }
        if(carry == 1) ans.insert(0, 1);
        return ans.toString();
    }
}