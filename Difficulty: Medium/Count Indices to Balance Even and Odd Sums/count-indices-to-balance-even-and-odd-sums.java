class Solution {
    
    public int[] sum(int index,int[] arr,int[] preSum,int[] postSum){
        int[] results=new int[2];
        int oddSum=0;
        int evenSum=0;
        int size=arr.length;
        int i=index;
        
        
        if(i%2==0){
            oddSum+=preSum[i]-arr[i];
            
            if(i+1<size){
            oddSum+=postSum[i+1];}
            
            if(i-1>=0){
            evenSum+=preSum[i-1];}
            
            if(i+2<size){
            evenSum+=postSum[i+2];}
            
            results[0]=oddSum;
            results[1]=evenSum;
            
            
            
        }else{
            evenSum+=preSum[i]-arr[i];
            
            if(i+1<size){
                evenSum+=postSum[i+1];
            }
            
            oddSum+=preSum[i-1];
            
            if(i+2<size){
                oddSum+=postSum[i+2];
            }
            
            results[0]=oddSum;
            results[1]=evenSum;
        }
        
        
        
        return results;
    }
    
    public int cntWays(int[] arr) {
        int size=arr.length;
        int[] preSum=new int[size];
        int[] postSum=new int[size];
        if(size==1){
            return 1;
        }
        
        preSum[0]=arr[0];
        preSum[1]=arr[1];
        
        for(int i=2;i<size;i++){
            preSum[i]=preSum[i-2]+arr[i];}
            
            postSum[size-1]=arr[size-1];
            postSum[size-2]=arr[size-2];
        
        for(int i=size-3;i>=0;i--){
            postSum[i]=postSum[i+2]+arr[i];
        }
        
        // System.out.println("presum is : "+Arrays.toString(preSum));
        // System.out.println("postsum is : "+Arrays.toString(postSum));
        
        int ways=0;
        
        for(int i=0;i<size;i++){
            int[] res=sum(i,arr,preSum,postSum);
            
            if(res[0]==res[1]){
                ways++;
            }
            
            // System.out.println("i is : "+i);
            // System.out.println("oddSUm is : "+temp[0]);
            // System.out.println("evenSum is : "+temp[1]+"\n\n");
        }
        
        
        return ways;
        
        
    }
}
