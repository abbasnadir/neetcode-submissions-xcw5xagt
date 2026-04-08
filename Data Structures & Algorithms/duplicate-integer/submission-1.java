class Solution {
    public boolean hasDuplicate(int[] nums) {
        int i = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(;i<nums.length;i++){
            if(hs.contains(nums[i])) return true;
            hs.add(nums[i]);
        }

        return false;
    }
}