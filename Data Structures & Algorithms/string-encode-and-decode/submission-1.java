class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String str: strs){
            s.append(str.length() + "#" + str);
        }
        
        return s.toString();
    }

   

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int n = 0;

            // 1. Parse length
            while (str.charAt(i) != '#') {
                n = n * 10 + (str.charAt(i) - '0');
                i++;
            }

            // 2. Skip delimiter '#'
            i++;

            // 3. Extract string of length n
            String word = str.substring(i, i + n);
            result.add(word);

            // 4. Move pointer forward
            i += n;
        }

        return result;
    }
}
