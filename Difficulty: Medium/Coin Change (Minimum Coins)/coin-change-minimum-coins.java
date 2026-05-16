class Solution {

    public  int coinsChange(int index,int target,int[] coins,int[][] dp){
        if(index==0){
            if(target%coins[0]==0){
                dp[index][target]=target/coins[index];
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


        int times=target/coins[index];
        int[] res=new int[2];


        res[0]=Integer.MAX_VALUE;
        res[1]=-1;

        for(int i=times;i>=0;i--){
            int newtarget=target-(coins[index]*i);
            int tempRes=coinsChange(index-1,newtarget,coins,dp);

            if(tempRes>=0){
                res[1]=0;
                res[0]=Math.min(res[0],tempRes+i);
            }

           
        }

    
        
        dp[index][target]=res[1]==-1?-1:res[0];

        return dp[index][target];
    } 



    public int minCoins(int[] coins, int amount) {
        int size=coins.length;
        

        int[] dp[]=new int[size][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-2);
        }

        coinsChange(size-1,amount,coins,dp);

    
        return dp[size-1][amount];
    }
}