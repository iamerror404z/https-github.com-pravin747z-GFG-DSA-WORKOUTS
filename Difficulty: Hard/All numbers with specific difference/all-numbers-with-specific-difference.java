class Solution {
    
    public int sumOfDigits(int n){
        int b=n;
        int sum=0;
        
        while(b!=0){
            int d=b%10;
            sum+=d;
            b/=10;
            
        }
        
        return sum;
    }
    
    public int getCount(int n, int d) {
        
        int end=n;
        
        
        int start=1;
        
        while(start<end){
            int mid=start+(end-start)/2;
            
            if(mid-sumOfDigits(mid)<d){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        
        if(start-sumOfDigits(start)<d){
            return 0;
        }
        
        
        
        return  n-start+1;
    }
};