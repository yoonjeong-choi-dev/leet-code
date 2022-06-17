class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> exists = new HashSet<>();
        for(int num : nums) {
            if(exists.contains(num)) return true;
            exists.add(num);
        }
        
        return false;
    }
}