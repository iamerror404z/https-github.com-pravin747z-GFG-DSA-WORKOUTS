class Solution {
    
    public int productMax(int index1,int index2,int[] a,int[] b,int[][] dp){
        if(index1<0 || index2<0){
            return 0;
        }
        
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        
       
        
        int currProduct=a[index1]*b[index2];
    
        int included=0;
        int excluded=0;
        
        
        
         included=productMax(index1-1,index2-1,a,b,dp)+currProduct;
        
        if(index1-index2>0){
        
        excluded=productMax(index1-1,index2,a,b,dp);
        }
        
        
        
        
        int res=Math.max(included,excluded);
        dp[index1][index2]=res;
        
        
        
        return res;
    }
    
    
    public int maxDotProduct(int[] a, int[] b) {
        int size1=a.length;
        int size2=b.length;
        
        int[][] dp=new int[size1][size2];
        
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        
        int ans=productMax(size1-1,size2-1,a,b,dp);
        // System.out.println(ans);
        
        return ans;
    }
}