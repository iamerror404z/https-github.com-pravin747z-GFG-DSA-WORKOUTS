class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int currXor=0;
        
        for(int i=0;i<k;i++){
            currXor^=arr[i];
        }
        
        int maxXor=currXor;
        
        for(int i=k;i<arr.length;i++){
            currXor=currXor^arr[i]^arr[i-k];
            maxXor=Math.max(currXor,maxXor);
        }
        
        
        return maxXor;
    }
}
