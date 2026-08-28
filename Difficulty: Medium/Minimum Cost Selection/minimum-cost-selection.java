class Solution {
    
    public int findMin(int row,int col,int[][] dp){
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<3;i++){
            if(i==col){
                continue;
            }
            
            
            min=Math.min(min,dp[row][i]);
        }
        
        return min;
    }
    
    
    
    public int minCost(int[][] mat) {
        int rowSize=mat.length;
        
        int[][] dp=new int[rowSize][3];
        
        
        for(int i=0;i<3;i++){
            dp[rowSize-1][i]=mat[rowSize-1][i];
        }
        
        
        
        for(int i=rowSize-2;i>=0;i--){
            for(int j=2;j>=0;j--){
                dp[i][j]=mat[i][j]+findMin(i+1,j,dp);
            }
        }
        
       
    //   for(int i[]:dp){
    //       System.out.println(Arrays.toString(i));
    //   }
        
        
        
        
        
        
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}