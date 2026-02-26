class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        int[] map1=new int[33];
        int[] map2=new int[33];
    
        
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            int index1=ch1-'a'+1;
            int index2=ch2-'a'+1;
            
            
            if(map1[index1]==0 && map2[index2]==0){
                map1[index1]=index2;
                map2[index2]=index1;
            }else if(map1[index1]!=index2 ){
                return false;
            }
            
            
        }
        
        
        
        
        return true;
    }
}