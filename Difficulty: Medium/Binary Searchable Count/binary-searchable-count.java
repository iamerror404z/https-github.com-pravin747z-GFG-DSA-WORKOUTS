class Solution {
    public int biSearch(int start,int end,int low,int high,int[] arr){
        if(start>end){
            return 0;
        }
        
        int left=0;
        int right=0;
        int res=0;
        
        int mid=start+(end-start)/2;
        
        int curr=arr[mid];
        
        if(low<curr && curr<high){
            res=1;
            
            left=biSearch(start,mid-1,low,curr,arr);
            right=biSearch(mid+1,end,curr,high,arr);
        }else{
            if(curr>high){
                left=biSearch(start,mid-1,low,high,arr);
                
            }else{
                right=biSearch(mid+1,end,low,high,arr);
            }
        }
        
        
        
        
        
        
        return left+res+right;
        
    }
    
    
    
    
    public int binarySearchable(int[] arr) {
        int res=biSearch(0,arr.length-1,-1,Integer.MAX_VALUE,arr);
        
        
        // System.out.println(res);
        
        return res;
        
    }
}