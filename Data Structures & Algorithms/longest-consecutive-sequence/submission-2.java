class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            if(hm.containsKey(nums[i])) continue;

            if(!hm.containsKey(nums[i]+1) && !hm.containsKey(nums[i]-1)){

                hm.put(nums[i], nums[i]);
                if(max == 0) max =1;

            } else if(hm.containsKey(nums[i]+1)){

                if(hm.containsKey(nums[i]-1)){
                    int lowest = hm.get(nums[i]-1);
                    int highest = hm.get(nums[i]+1);
                    hm.remove(nums[i]+1);
                    hm.remove(nums[i]-1);
                    hm.put(highest,lowest);
                    hm.put(lowest,highest);

                    if(max<highest-lowest+1) max = highest-lowest+1;
                } else {
                    int lowest = hm.get(nums[i]+1);
                    
                    if(nums[i]+1 > lowest) continue;
                    else if(nums[i]+1 == lowest){
                        hm.replace(nums[i]+1,nums[i]);
                        hm.put(nums[i],nums[i]+1);

                        if(max < 2) max=2;
                    } else {
                        hm.remove(nums[i]+1);
                        hm.put(nums[i],lowest);
                        hm.replace(lowest, nums[i]);

                        if(max < lowest-nums[i]+1) max=lowest-nums[i]+1;
                    }
                }
            } else if(hm.containsKey(nums[i]-1)) {

                int highest = hm.get(nums[i]-1);
                if(nums[i]-1 < highest) continue;

                else if(nums[i]-1 == highest){
                    hm.replace(nums[i]-1,nums[i]);
                    hm.put(nums[i],nums[i]-1);

                    if(max < 2) max=2;
                } else {
                    hm.remove(nums[i]-1);
                    
                    hm.put(nums[i],highest);
                    hm.replace(highest, nums[i]);

                    if(max < nums[i]-highest+1) max=nums[i]-highest+1;
                }
            }
        }
        return max;
    }
}
