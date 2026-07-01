class Solution {
    
    public int divByK(int index,int target,int k,int[] arr,int[][] dp){
        if(index==0){
            int res=0;
            if(arr[0]%k==target){
                res=1;
            }
            
            dp[index][target]=res;
            
            return res;
        }
        
        if(arr[index]%k==target){
            dp[index][target]=1;
            return 1;
        }
        
        if(dp[index][target]!=2){
            return dp[index][target];
        }
        
        int currMod=arr[index]%k;
        
        int newTarget=target-currMod;
        
        if(newTarget<0){
            newTarget+=k;
        }
        
        
        
        int res=0;
        
        int included=divByK(index-1,newTarget,k,arr,dp);
        int excluded=divByK(index-1,target,k,arr,dp);
        
        res=Math.max(included,excluded);
        
        // System.out.println("curr number is : "+arr[index]+"    included is : "+included
        // +"  excluded is :  "+excluded);
        
        dp[index][target]=res;
        
        
        return res;
        
    }
    
    
    
    
    public boolean divisibleByK(int[] arr, int k) {
        int size=arr.length;
        
        int[][] dp=new int[size][k+1];
        
        for(int i[]:dp){
            Arrays.fill(i,2);
        }
        
        divByK(size-1,0,k,arr,dp);
        
        
        
        return dp[size-1][0]==1;
    }
}