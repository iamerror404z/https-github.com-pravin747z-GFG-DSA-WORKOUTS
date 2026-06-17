class Solution {
    
    public int maxProductDP(int index,int target,int[][]  dp){
        if(index==1 || target<=1){
            dp[index][target]=1;
            
            
            return dp[index][target];
        }
        
        
        if(dp[index][target]!=0){
            return dp[index][target];
        }
        
        int max=1;
        
        int times=target/index;
        
        for(int i=times;i>=0;i--){
            int newTarget=target-(i*index);
            int prod=(int)Math.pow(index,i);
            
            int res=maxProductDP(index-1,newTarget,dp);
            
            max=Math.max(max,res*prod);
            
            
        }
        
        
        dp[index][target]=max;
        
        
        
        
        
        
        
        
        
        
        
        return dp[index][target];
    }
    
    
    
    
    public int maxProduct(int n) {
        if(n<=3){
            return n-1;
        }
        
        if(n==4){
            return 4;
        }
        
        int[][] dp=new int[n+1][n+1];
        
        maxProductDP(n,n,dp);
        
        
        
        
        
        
        
        
        
        return dp[n][n];
    }
}