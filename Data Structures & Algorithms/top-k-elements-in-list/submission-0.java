class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int num: nums){
            hm.merge(num, 1, Integer::sum);
        }

        for(int key: hm.keySet()){
            int freq = hm.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int[] output = new int[k];
        int outputTrack = 0;
        for(int i = nums.length; i>0; i--){
            if(k==0) break;
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    output[outputTrack] = num;
                    outputTrack++;
                    k--;
                }
            }
        }

        return output;
    }
}
