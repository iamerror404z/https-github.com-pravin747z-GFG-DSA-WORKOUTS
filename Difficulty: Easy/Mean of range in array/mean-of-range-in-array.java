class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
     ArrayList<Integer> list=new ArrayList<>();
        int size=arr.length;    
        int[] preSum=new int[size];
        preSum[0]=arr[0];
        for(int i=1;i<size;i++){
            preSum[i]=preSum[i-1]+arr[i];
        }
        
        for(int i[]:queries){
            int left=i[0];
            int right=i[1];
            list.add((preSum[right]-preSum[left]+arr[left])/(right-left+1));
        }
        
        return list;
    
    }
}