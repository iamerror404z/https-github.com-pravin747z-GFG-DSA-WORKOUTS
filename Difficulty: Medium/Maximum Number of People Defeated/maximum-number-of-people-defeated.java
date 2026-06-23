class Solution {
    
    public int binarySearch(int start,int end,int target){
        int max=0;
        
        while(start<=end){
            
            int mid=start+(end-start)/2;
            
            long n=(long)mid;
            
            long ans=n*(n+1)*((2*n)+1)/6;
            
            if(ans>target){
                end=mid-1;
            }else{
                max=mid;
                start=mid+1;
            }
            
        }
        
        
        return max;
    }
    
    
    
    
    
    
    int maxPeopleDefeated(int p) {
        int max=3*((int)Math.pow(10,8));
        
        int sum=1500;
        
        int res=binarySearch(1,Math.min(p,1000),p);
        
          
        
        
        return res;
    }
}