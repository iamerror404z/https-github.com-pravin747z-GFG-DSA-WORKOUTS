class Solution {
    int maxOnes(int[] arr) {
        int start=0;
        int end=0;
        int currSum=0;
        int ones=0;
        int[] max=new int[3];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                currSum--;
                ones++;
            }else{
                currSum++;
            }
            
            if(currSum<=0){
                start=i+1;
                currSum=0;
            }
        
        if(currSum>max[0]){
            max[0]=currSum;
            max[1]=start;
            max[2]=i;
            
        }
            
        }
        
        
        return max[0]+ones;
    }
}