class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n=grid.length;
        
        int[][] dp=new int[n][n];
        int mod=(int)Math.pow(10,9)+7;
        
        
        int max[]=new int[n];
        // process the boundaries first ??
        
        dp[n-1][n-1]=1;
        max[n-1]=grid[n-1][n-1];
        
        
        for(int i=n-2;i>=0;i--){
            int curr=grid[n-1][i];
            
            if(curr==2){
                continue;
            }
            
            dp[n-1][i]=dp[n-1][i+1];
            
            
            if(max[i+1]!=0){
                max[i]=curr+max[i+1];
                
            }
            
        }
        
       
    
        
        int[] swap=new int[n];
        
        
        for(int i=n-2;i>=0;i--){
            int edge=grid[i][n-1];
            
            if(edge!=1){
                dp[i][n-1]=dp[i+1][n-1];
             
            }
            
        // about the max path 
        
            if(edge!=1 && max[n-1]!=0){
                swap[n-1]=max[n-1]+edge;
            }else{
                swap[n-1]=0;
            }
            
            
            for(int j=n-2;j>=0;j--){
                int curr=grid[i][j];
                
                int right=curr!=2?dp[i][j+1]:0;
                int down=curr!=1?dp[i+1][j]:0;
                
                
                long sum=((long)right)+down;
                dp[i][j]=(int)(sum%mod);
                
                
                int rightMax=swap[j+1];
                int downMax=max[j];
                
                if(curr!=2 && rightMax!=0){
                    swap[j]=curr+rightMax;
                }else{
                    swap[j]=0;
                }
                
                if(curr!=1 && downMax!=0){
                    swap[j]=Math.max(swap[j],downMax+curr);
                }
                
                
            }
            
            // roatate the swap here , we are dealing with references not actual values !
            int[] temp=max;
            max=swap;
            swap=temp;
            
            
        }
        
        
         ArrayList<Integer> res=new ArrayList<>();
            res.add(dp[0][0]);
            res.add(max[0]);
        
        
        
        
        
        
        
        
        return res;
        
    }
}