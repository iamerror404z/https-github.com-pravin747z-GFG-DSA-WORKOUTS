class Solution {
    
    public int countWays(int prev,int size,int[][] memo){
        if(size==0){
            return 1;
        }
        
        if(memo[prev][size]!=-1){
            return memo[prev][size];
        }
        
        int count=0;
        
        for(int i=1;i<memo.length;i++){
            if(prev%i==0 || i%prev==0){
                count+=countWays(i,size-1,memo);
            }
        }
        
        
        
        memo[prev][size]=count;
        
        return count;
        
    }
    
    
    
    
    public int count(int n, int m) {
        int[][] memo=new int[m+1][n+1];
        
        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        
        int res=countWays(0,n,memo);
        
        
        
        
        return res;
        
    }
}