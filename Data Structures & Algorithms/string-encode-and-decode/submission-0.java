class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String str: strs){
            s.append(str.length() + "#" + str);
        }
        
        return s.toString();
    }

   

    public List<String> decode(String str) {
        int len = str.length();
        int n = 0, i =0;
        List<String> ls = new ArrayList<>();

        while(i<len){
            if(str.charAt(i) == '#'){
                i++;
                ls.add(str.substring(i,n+i));
                i+=n; n=0;
            } else {
                int c = str.charAt(i)-48;
                n=(n*10) + c;

                i++;
            }
        }

        return ls;
    }
}
