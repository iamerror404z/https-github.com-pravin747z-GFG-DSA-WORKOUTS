class Solution {
    void pushZerosToEnd(int[] arr) {
        int index1=0;
        int index2=0;
        
        int length=arr.length;
        
        while(index1<length && index2<length){
            while(index2<length && arr[index2]==0){
                index2++;
            }
            
            if(index2<length && index1!=index2){
                arr[index1]=arr[index2];
                arr[index2]=0;
                
            }
            
            
            index2++;
            index1++;
        }
    
    }
}