class Solution {
    int minSubsets(int arr[]) {
        Arrays.sort(arr);
        
        int intervals=0;
        int length=arr.length;
        
        int prev=arr[0];
        
        for(int i=1;i<length;i++){
            int curr=arr[i];
            
            if(curr-prev!=1){
                intervals++;
            }
            
            
            
            
            prev=curr;
        }
        
        
        return intervals+1;
    }
}