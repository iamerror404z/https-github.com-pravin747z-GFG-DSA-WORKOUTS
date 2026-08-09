/**
 * author : github@iamerror404z 
 * category:
        DP , found it instantly but failed to understand all the possiblites and tcs

*/





class Solution {
    
    
    public int[] updateDP(int[] dp,int[] tempDP){
        int prev=0;
        int n=dp.length;
        
        for(int i=0;i<n;i++){
            int curr=tempDP[i];
            
            
            dp[i]=prev;
            
            prev=Math.max(curr,prev);
        }
        
        
        prev=0;
        
        for(int i=n-1;i>=0;i--){
            int curr=tempDP[i];
            
            
            dp[i]=Math.max(prev,dp[i]);
            prev=Math.max(prev,curr);
        }
        
        
        
        
        return dp;
        
    }
    
    
    
    public int zigzagSequence(int[][] mat) {
        int n=mat.length;
        
        
        int max=0;
        int[] dp=new int[n];
        int[] tempDP=new int[n];
        
        for(int i=0;i<n;i++){
            tempDP[i]=mat[n-1][i];
            
            max=Math.max(max,tempDP[i]);
        }
        
        
        
        
        dp=updateDP(dp,tempDP);
        
        for(int i=n-2;i>=0;i--){
            
            for(int j=n-1;j>=0;j--){
                int curr=mat[i][j];
                
                tempDP[j]=curr+dp[j];
                max=Math.max(max,tempDP[j]);
            }
            
            dp=updateDP(dp,tempDP);
        }
        
        
        
        
    
        
        
        
        
        return max;
    }
}
