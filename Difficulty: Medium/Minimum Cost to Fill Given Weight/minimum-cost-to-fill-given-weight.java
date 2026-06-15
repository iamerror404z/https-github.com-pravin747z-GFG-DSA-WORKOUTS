class Solution {
    
    public int dpSum(int index,int target,int[][] dp,int[] cost){
        if(index==0){
            if(cost[index]!=-1 || target==0){
                int indexCost=target*cost[0];
                dp[index][target]=indexCost;
                
            }else{
                dp[index][target]=-1;
            }
            
            return dp[index][target];
            
        }
        
        if(dp[index][target]!=-2){
            return dp[index][target];
        }
        
        if(target==0){
            dp[index][target]=0;
            
            return dp[index][target];
        }
        
        
        
        
        int times=target/(index+1);
        
        if(cost[index]==-1){
            times=0;
        }
        
        int[] res=new int[]{Integer.MAX_VALUE,0};
        
        
        for(int i=times;i>=0;i--){
            int newTarget=(target)-(i*(index+1));
            int indexCost=i*cost[index];
            
            int min=dpSum(index-1,newTarget,dp,cost);
            
            if(min>=0){
                res[0]=Math.min(res[0],min+indexCost);
                res[1]=1;
            }
            
        }
        
        
        
        if(res[1]==1){
            dp[index][target]=res[0];
        }else{
            dp[index][target]=-1;
        }
        
        
        
        
        
        
        
        
        return dp[index][target];
    }
    
    
    
    
    public int minimumCost(int[] cost, int w) {
        
        int costSize=cost.length;
        
        int cap=Math.min(costSize,w);
        
        int[][] dp=new int[cap][w+1];
        
        for(int i[]:dp){
            Arrays.fill(i,-2);
        }
        
        dpSum(cap-1,w,dp,cost);
        
        
        
        return dp[cap-1][w];
    }
}