class Solution {
    public boolean canSplit(int arr[]) {
        long sum=0;
        
        for(int i:arr){
            sum+=i;
        }
        
        long left=0,right=0;
        
        for(int i:arr){
            left+=i;
            right=sum-left;
            
            if(left==right){
                return true;
            }
        }
        
        
        
        return false;
    }
}