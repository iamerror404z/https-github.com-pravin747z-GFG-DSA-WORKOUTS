class Solution {
    
    public int recursion(int currNumber){
        int curr[]=new int[3];
        
        int sum=0;
        for(int i=2;i<=4;i++){
            curr[i-2]=currNumber/i;
            sum+=curr[i-2];
            
        }
        
        
        if(sum<=currNumber){
            return sum;
        }
        
        
        for(int i=0;i<3;i++){
            curr[i]=Math.max(curr[i],recursion(curr[i]));
        }
        
        
        sum=0;
        
        for(int i:curr){
            sum+=i;
        }
        
        
        return sum;
        
        
    }
    
    
    
    public int maxSum(int n) {
        int currMax=0;
        
        int nee=recursion(n);
        
        
        return Math.max(n,nee);
    }
}
