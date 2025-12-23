class Solution {
    public int starting(int target,int[] arr){
        if(arr[0]>=target){
            return 0;
        }
        
        int start=0;
        int size=arr.length;
        int end=size-1;
        
        if(arr[end]<target){
            return Integer.MAX_VALUE;
        }
        
        
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(mid-1>=0 && arr[mid]>=target  && arr[mid-1]<target){
                return mid;
            }
            
            
            if(arr[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
            
            
            
            
        }
        
        
        
        
        return 0;
        
    }
    
    
    public int ending(int target,int[] arr){
        int size=arr.length;
        
        if(arr[size-1]<=target){
            return size-1;
        }
        
        
        
        
        int start=0;
        int end=size-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(mid+1<size && arr[mid]<=target && arr[mid+1]>target){
                return mid;
            }
            
            if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
        
        
        
        
        
        
        return -1;
    }
    
    
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<Integer> list=new ArrayList<>();
        
        int start=starting(3,arr);
        int end=ending(5,arr);
        // System.out.println(start);
        
        for(int i[]:queries){
            int nums=ending(i[1],arr)-starting(i[0],arr)+1;
            // System.out.println(nums);
            list.add(Math.max(0,nums));
        }
        
    
        
        
        
        return list;
    }
}
