class Solution {
    
    public static int updateStart(int start,int end,int k,int[] arr){
        int pos=start;
        
        
        while(start<=end && arr[end]-arr[start]>=k){
            start++;
        }
        
        return start;
    }
    
    
    public static int countPairs(int arr[], int k) {
        int length=arr.length;
        Arrays.sort(arr);
        int res=0;
        
        int start=0;
        
        for(int i=1;i<length;i++){
            int curr=arr[i];
            
            start=updateStart(start,i,k,arr);
            
            int size=i-start;
            
            res+=size;
        }
        
        
        return res;
        
    }
}
