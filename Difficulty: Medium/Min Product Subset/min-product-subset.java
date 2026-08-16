class Solution {
    public int minProd(int[] arr) {
        int min=arr[0];
        int length=arr.length;
        
        
        int negVal=0;
        int negMin=Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            int curr=arr[i];
            
            if(curr<0){
                negVal++;
                
                negMin=Math.min(negMin,Math.abs(curr));
                
            }
            
            min=Math.min(min,curr);
        }
        
        
        if(negVal==0){
            return min;
        }
        
        int res=1;
        
        for(int i=0;i<length;i++){
            int curr=arr[i];
            
            
            res*=(curr==0?1:curr);
        }
        
        
        if(negVal%2==0){
            res/=(-1*negMin);
        }
        
        
        
        // System.out.println("min is : "+min);
        return res;
    }
}