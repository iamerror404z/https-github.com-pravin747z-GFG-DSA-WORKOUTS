class Solution {
    
    public int binarySearch(int[] arr,int k){
        int start=0;
        int size=arr.length;
        int end=arr.length;
        
        if(k<arr[0]){
            return -1;
        }
        
        if(arr[size-1]<k){
            return size-1;
        }
        
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(arr[mid]==k){
                return mid-1;
            }
            
            if(mid+1<size){
            if(arr[mid]<k &&arr[mid+1]>k){
                return mid;}
            }
            
            if(arr[mid]>k){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
        
        
        
        return -1;
    }    
    
    public int searchInsertK(int arr[], int k) {
        
        
        return binarySearch(arr,k)+1;
        
    }
};