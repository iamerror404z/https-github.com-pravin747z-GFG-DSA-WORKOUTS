class Solution {
    
    public static int count(int pointer1,int pointer2,String s1,String s2,int[][] dp,int[] mod){
        if(pointer2<0){
            return 1;
        }
        
        
        
        if(pointer1<0){
            return 0;
        }
        
        
        int nextResult=0;
        
        
        
        if(dp[pointer1][pointer2]!=-1){
            return dp[pointer1][pointer2];
        }
        
        if(s1.charAt(pointer1)==s2.charAt(pointer2)){
            int included=count(pointer1-1,pointer2-1,s1,s2,dp,mod);
            int excluded=count(pointer1-1,pointer2,s1,s2,dp,mod);
            
            nextResult=(included%mod[0])+(excluded%mod[0]);
        }else{
            int excluded=count(pointer1-1,pointer2,s1,s2,dp,mod);
            
            nextResult=excluded%mod[0];
        }
        
        
        dp[pointer1][pointer2]=nextResult;
     
        
        
        
        return dp[pointer1][pointer2];
    }
    
    
    
    public static int countWays(String s1, String s2) {
        final int[] mod=new int[]{(int)1e9+7};
        // System.out.println(mod[0]);
        int size1=s1.length();
        int size2=s2.length();
        
        int[][] dp=new int[size1][size2];
        
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        
       
        
        count(size1-1,size2-1,s1,s2,dp,mod);
        
        // System.out.println(dp[size1-1][size2-1]);
        
        
        return dp[size1-1][size2-1]%mod[0];
    }
}
