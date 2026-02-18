class Solution {
    
    public static  void sort(int start,int mid,int end,int[] arr,int count[]){
        int size=end-start+1;
        int []temp=new int[size];
        int index=0;
        
        int pointer1=start;
        int pointer2=mid+1;
        
        while(pointer1<=mid && pointer2<=end){
            if(arr[pointer1]<=arr[pointer2]){
                temp[index++]=arr[pointer1++];
            }else{
                count[0]+=(mid-pointer1+1);
                temp[index++]=arr[pointer2++];
            }
        }
        
        while(pointer1<=mid){
            temp[index++]=arr[pointer1++];
        }
        
        while(pointer2<=end){
            temp[index++]=arr[pointer2++];
        }
        
        for(int i=start;i<=end;i++){
            arr[i]=temp[i-start];
        }
        
    }
    
    public static void divide(int start,int end,int[] arr,int[] count){
        if(start>=end){
            return ;
        }
        int mid=start+(end-start)/2;
        divide(start,mid,arr,count);
        divide(mid+1,end,arr,count);
        
        sort(start,mid,end,arr,count);
        
        
    }
    
    
    
    
    static int inversionCount(int arr[]) {
        int[] count=new int[1];
        divide(0,arr.length-1,arr,count);
        
        // System.out.println(Arrays.toString(arr));
        // System.out.println(count[0]);
        
        return count[0];
    }
}