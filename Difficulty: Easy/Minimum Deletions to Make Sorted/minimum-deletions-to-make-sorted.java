/*triggered byt the word "easy"

    later only realised;
    
    this is same  as longest incresing subsequence;

*/

class Solution {
    
    
    public int position(int[] lis,int start, int end,int target){
        
        int pos=-1;
        
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            // System.out.println("mid is : "+arr[mid]);
            if(lis[mid]>=target){
                end=mid-1;
            }else{
                pos=mid;
                start=mid+1;
            }
        }
        
        
        
        
        return pos+1;
    }
    
    
    
    public int minDeletions(int[] arr) {
        int size=arr.length;
       int[] lis=new int[size];
       
       lis[0]=arr[0];
       int start=0;
       int end=0;
       
       
       for(int i=1;i<size;i++){
           int res=position(lis,0,end,arr[i]);
           
           if(res==0){
               lis[0]=arr[i];
           }else if(res>end){
               end++;
               lis[end]=arr[i];
           }else{
               lis[res]=arr[i];
           }
       }
       
       
       
    //   System.out.println(Arrays.toString(lis));
       
       
    //   System.out.println("end is : "+end);
       
       return size-end-1;
        
    }
}