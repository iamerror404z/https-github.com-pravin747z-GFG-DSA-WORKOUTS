class Solution {
    public int maxSumSubarray(int[] arr) {
        int max=arr[0];
        
        for(int i:arr){
            max=Math.max(max,i);
        }
        
        if(max<=0){
            return max;
        }
        
        
        int[] prevSum=new int[2];
        
        // prevSum[0] refers to the previous subarray sum without using the skip
        // prevSum[1] refers to the previous subarray Sum while skipping atmax one elemenet;
        
        for(int i:arr){
            if(i>=0){
                prevSum[0]+=i;
                prevSum[1]+=i;
                
                int tempMax=Math.max(prevSum[0],prevSum[1]);
                max=Math.max(max,tempMax);
            }else{
                
                
                // System.out.println(Arrays.toString(prevSum));
                int prevSkipped=prevSum[1]+i;
                int currSkipped=prevSum[0];
                
                prevSum[0]=Math.max(prevSum[0]+i,0);
                prevSum[1]=Math.max(0,Math.max(prevSkipped,currSkipped));
                
            }
            
            
            
        }
        
        
        
        
        
        return max;
    }
}