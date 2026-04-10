class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for(int j =0; j < strs.length; j++){
            int[] arr = new int[26];

            String str = strs[j];
            int len = str.length();
            for(int i = 0; i<len; i++){
                arr[((int) str.charAt(i))-97]++;
            }

            String n =Arrays.toString(arr);
            
                hm.computeIfAbsent(n, k -> new ArrayList<>()).add(str);
        
        }

        List<List<String>> lls = new ArrayList<>();

        for(List<String> ls: hm.values()){
            lls.add(ls);
        }

        return lls;
    }
}
