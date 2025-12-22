// User function Template for Java

class Solution {
    
    public int starting(int left,int right,int arr[]){
        
        if(arr[left]==1){
            return left;
        }
        
        
        if(arr[right]!=1){
            return right+1;
        }
        
        
        int start=left;
        int end=right;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(mid-1>=0 && arr[mid]==1 && arr[mid-1]==0){
                return mid;
            }
            
            if(arr[mid]<1){
                start=mid+1;
            }else{
                end=mid-1;
            }
            
        }
        
        
        return 0;
    }
    
    
    public int rowWithMax1s(int arr[][]) {
        int m=arr.length;
        int n=arr[0].length;
        int[] max=new int[2];
        max[1]=-1;
        int pointer=0;
        
        for(int i[]:arr){
        int size=n-starting(0,n-1,i);
        if(max[0]<size){
            max[0]=size;
            max[1]=pointer;
        }
        pointer++;
        // System.out.println(size);
        
        }
        
        
        
        return max[1];
    }
}