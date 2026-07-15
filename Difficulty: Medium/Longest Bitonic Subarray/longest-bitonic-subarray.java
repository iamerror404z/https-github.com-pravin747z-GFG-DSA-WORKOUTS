class Solution {
    public int bitonic(int[] arr) {
        int[] pos=new int[]{0,-1};
        int size=arr.length;
        
        int prev=0;
        int maxSize=1;
        
        
        
        for(int i=0;i<size;i++){
            int curr=arr[i];
            
            if(pos[1]!=-1){
                if(curr<prev){
                    pos[1]=i;
                }else if(curr>prev){
                    pos[0]=pos[1];
                    pos[1]=-1;
                } 
                
            }else{
                if(curr<prev){
                    pos[1]=i;
                }
            }
            
            int tempSize=i-pos[0]+1;
            // System.out.println(Arrays.toString(pos));
            // System.out.println(tempSize);
            
            maxSize=Math.max(maxSize,tempSize);
            
            prev=curr;
        }
        
        
        // System.out.println(maxSize);
        
        return maxSize;
    }
}