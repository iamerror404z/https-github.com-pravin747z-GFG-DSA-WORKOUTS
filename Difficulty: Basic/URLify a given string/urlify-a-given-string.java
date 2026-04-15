class Solution {
    String URLify(String s) {
        StringBuilder url=new StringBuilder();
        StringBuilder space=new StringBuilder("%20");
        for(char ch:s.toCharArray()){
            if(ch==' '){
                url.append("%20");
            }else{
                url.append(ch);
            }
        }
        
        
        return url.toString();
    }
}