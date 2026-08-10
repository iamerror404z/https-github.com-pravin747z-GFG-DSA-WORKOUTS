class Solution {
    
    public int dp(int prev,int index,int[][] memo,int[] h,int[] l){
        if(index>=h.length){
            return 0;
        }
        
        if(memo[prev][index]!=-1){
            return memo[prev][index];
        }
        
        
        // either take it or leave it !
        
        // take it part
        int included=l[index]+dp(1,index+1,memo,h,l);
        
        // take the val from h !
        
        if(prev==0){
            int tempMax=h[index]+dp(1,index+1,memo,h,l);
            included=Math.max(included,tempMax);
        }
        
        // leave it part
        int excluded=dp(0,index+1,memo,h,l);
        
        int max=Math.max(included,excluded);
        
        
        
        memo[prev][index]=max;
        
        return max;
        
    }
    
    
    
    
    
    public int maxTask(int[] h, int[] l) {
        int length=h.length;
        int[][] memo=new int[2][length];
        
        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        
        int res=dp(0,0,memo,h,l);
        
        
        return res;
    }
}