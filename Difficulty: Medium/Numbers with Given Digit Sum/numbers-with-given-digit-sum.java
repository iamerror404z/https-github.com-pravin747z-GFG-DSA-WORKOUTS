class Solution {
    /*
     *faiedl on the first attempt fogot to apply to memoisation !
     
     
     
    */
    
    
    public int DP(int n,int sum,int[][] memo){
        
        if(n<0 || sum<0){
            return 0;
        }
        
        if(n==0){
            return (sum==0?1:0);
        }
        
        
        if(sum==0){
            memo[n][sum]=n;
            
            return 1;
        }
        
        
        
        if(memo[n][sum]!=-1){
            return memo[n][sum];
        }
        
        int ans=0;
        
        for(int i=0;i<=9;i++){
            ans+=DP(n-1,sum-i,memo);
        }
        
        memo[n][sum]=ans;
        
        
        return ans;
    }
    
    
    
    
    public int countWays(int n, int sum) {
        int[][] memo=new int[n+1][sum+1];
        
        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        
        int ans=0;
        
        
        for (int i = 1; i <= 9; i++) {
            if (sum - i >= 0) {
                ans += DP(
                    n - 1, sum - i, memo);
            }
        }
        
        
        if(ans==0){
            return -1;
        }
        
        
        
        return ans;
    }
}