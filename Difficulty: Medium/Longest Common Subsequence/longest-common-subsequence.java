class Solution {
    
     public static int findLCS(int index1,int index2,String s1,String s2,int[][]  dp){
        if(index1<0 || index2<0){
            return 0;
        }
        
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        
        int res=0;
        int included=0;
        
        
        if(s1.charAt(index1)==s2.charAt(index2)){
            included=findLCS(index1-1,index2-1,s1,s2,dp)+1;
            res=included;
        }else{
            int skipIndex2=findLCS(index1-1,index2,s1,s2,dp);
            int skipIndex1=findLCS(index1,index2-1,s1,s2,dp);
            
            res=Math.max(skipIndex1,skipIndex2);
        }
        
        dp[index1][index2]=res;
        
        
        return res;
    }
    
    
    
    static int lcs(String s1, String s2) {
       int size1=s1.length();
     int size2=s2.length();
     
     int[][] dp=new int[size1][size2];
     
     for(int i[]:dp){
         Arrays.fill(i,-1);
     }
     
     
     int LCS=findLCS(size1-1,size2-1,s1,s2,dp);
        
        
        return LCS;
    }
}