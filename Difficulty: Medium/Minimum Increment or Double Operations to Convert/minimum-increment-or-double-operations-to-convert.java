class Solution {
    public int countMinOperations(int arr[]) {
        int  even=0;
        int odd=0;
        
        
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            
            int locEven=0;
            
            while(curr>0){
                if(curr%2==0){
                    curr/=2;
                    locEven++;
                }else{
                    curr-=1;
                    odd++;
                }
            }
            
            even=Math.max(even,locEven);
            
        }
        
      
        
        
        return even+odd;
    }
}