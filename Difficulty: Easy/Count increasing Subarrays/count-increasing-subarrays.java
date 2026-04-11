class Solution {
    public int countIncreasing(int[] arr) {
        int count=0;
        int size=arr.length;
        int []track=new int[2];
        track[0]=size-1;
        track[1]=size-1;
        
        
        
        
        for(int i=size-2;i>=0;i--){
            if(arr[i]<arr[track[0]]){
                track[0]=i;
            }else{
                track[0]=i;
                track[1]=i;
            }
            
            int subArrayPossibilities=track[1]-track[0];
            count+=subArrayPossibilities;
        }
        
        
        
        return count;
    }
}
