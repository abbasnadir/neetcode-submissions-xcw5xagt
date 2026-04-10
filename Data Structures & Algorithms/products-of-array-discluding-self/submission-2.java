class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] output = new int[nums.length];
        int zeroCount = 0;
        for(int num: nums){
            if(num == 0){
                zeroCount++;
                continue;
            }

            product*=num;
        }
        if(zeroCount > 0){
            for(int i = 0; i<nums.length; i++){
                if(nums[i] == 0 && zeroCount == 1) output[i]=product;
                else output[i] = 0;
            }
        }
        else{
            for(int i = 0; i<nums.length; i++){
                output[i] = product/nums[i];
            }
        }

        return output;
    }
}