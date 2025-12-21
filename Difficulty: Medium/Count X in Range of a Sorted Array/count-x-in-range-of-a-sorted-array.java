class Solution {
    
    public int finish(int[] arr,int left,int right,int target){
        int start=left;
        int end=right;
        
        if(arr[end]==target){
            return end;
        }
        
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            // System.out.println(arr[mid]+" the pos is : "+mid);
            
            if(mid+1<=right && arr[mid]==target && arr[mid+1]>target){
                return mid;
            }
            
            if(arr[mid]<=target){
                start=mid+1;
            }else{
                end=mid-1;
            }
            
        }
        
        
        
        
        return -1;
        
    }
    
    
    public int starting(int[] arr,int left,int right,int target){
        if(arr[left]==target){
            return left;
        }
        
        int start=left;
        int end=right;
        
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            
            if(mid-1>=0 && arr[mid]==target && arr[mid-1]<target){
                return mid;
            }
            
            
            if(arr[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
            
        }
        
        
        return 0;
        
        
        
        
    }
    
    
    
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int[] i:queries){
            int count=finish(arr,i[0],i[1],i[2])-starting(arr,i[0],i[1],i[2]);
                list.add(count+1);
        }
        
        
        
        return list;
    }
}