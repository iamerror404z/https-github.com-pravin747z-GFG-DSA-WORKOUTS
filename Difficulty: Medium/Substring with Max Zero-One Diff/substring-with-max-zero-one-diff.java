class Solution {
    int maxSubstring(String s) {
        int max=-1;
        int zeroCount=0;
        int oneCount=0;
        
        
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'0';
            
            if(curr==1){
                oneCount++;
            }else{
                zeroCount++;
            }
            
            if(zeroCount-oneCount<=0){
                oneCount=0;
                zeroCount=0;
            }
            
            if(oneCount>0 || zeroCount>0){
            
            max=Math.max(max,zeroCount-oneCount);}
            
            
            
            
        }
        
        
        
        
        
        return max;    
    }
}