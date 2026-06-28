class Solution {
    
    
    public int countWays(int currIndex,int remK,int prev,int[][][] dp){
        if(remK<0){
            return 0;
        }
        
        if(currIndex==0){
            int res=0;
            if(remK==0){
                res=1;
            }
            
            dp[currIndex][remK][prev]=res;
            
            return res;
        }
        
        
        
        
        if(dp[currIndex][remK][prev]!=-1){
            return dp[currIndex][remK][prev];
        }
        
        
        
        
        int nextK=remK;
        
        if(prev==1){
            nextK=remK-1;
        }
        
        int withOne=countWays(currIndex-1,nextK,1,dp);
        int withZero=countWays(currIndex-1,remK,0,dp);
        
        
        long sum=((long)withOne)+withZero;
        int mod=(int)Math.pow(10,9)+7;
        
        
        int res=(int)(sum%mod);
        
        dp[currIndex][remK][prev]=res;
        
        
        return dp[currIndex][remK][prev];
        
    }
    
    
    
    
    
    
    public int countStrings(int n, int k) {
       
       int[][][] dp=new int[n][k+1][2];
       
       for(int i[][]:dp){
           for(int j[]:i){
               Arrays.fill(j,-1);
           }
       }
       
       
       
       int ans1=countWays(n-1,k,1,dp);
       int ans2=countWays(n-1,k,0,dp);
       
       
       long ans=((long)ans1)+ans2;
       
       int mod=(int)Math.pow(10,9)+7;
       
       int res=(int)(ans%mod);
        
        
        
        
        
        return res;
    }
}