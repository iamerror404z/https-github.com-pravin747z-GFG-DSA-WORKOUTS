class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        Arrays.sort(arr);
        
        int max=0;
        
        int size=arr.length;
        
        int prev=-1;
        
        for(int i=size-1;i>=0;i--){
            int curr=arr[i];
            if(prev!=-1){
                if(prev-curr<k){
                    max+=prev+curr;
                    prev=-1;
                }else{
                    prev=curr;
                }
            }else{
                prev=curr;
            }
        }
        
        
        
        // System.out.println(Arrays.toString(arr));
        return max;
    }
}