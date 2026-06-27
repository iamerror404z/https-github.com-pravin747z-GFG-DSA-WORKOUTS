class Solution {
    
    /*
    dp problem intilally struglled alot
    reference : https://www.youtube.com/watch?v=x2AgFV2QMok
    
    needs to improve way ot thiking
    
    more problem solvig skills required;
    */
    
    
    
    public int countWays(int n, int m) {
        if(m>n){
            return 1;
        }
        
        final int mod=(int)Math.pow(10,9)+7;
        
        int[] dp=new int[n+1];
        
        dp[0]=1;
        
        
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1];
            
            
            if(i>=m){
                long sum=(long)dp[i];
                sum+=dp[i-m];
                
                // System.out.println("i is : "+i+"  sum is "+sum);
                dp[i]=(int)(sum%mod);
            }
            
            
        }
        
        
        
        
        
        
        return dp[n];
    }
}