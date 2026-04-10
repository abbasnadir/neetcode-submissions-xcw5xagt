class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int len = s.length();
        if(len != t.length()) return false;

        for(int i=0; i< len; i++){
            char curr = s.charAt(i);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        }

        for(int i=0; i< len; i++){
            char curr = t.charAt(i);
            if(hm.getOrDefault(curr, 0) != 0) hm.put(curr, hm.get(curr) - 1);
            else return false;
        }
        return true;
    }
}
