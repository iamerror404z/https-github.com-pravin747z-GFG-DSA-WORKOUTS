class Solution {
    
    public int maxPath(int[] a,int[] b){
        int size1=a.length;
        int size2=b.length;
        
        int pointer2=0;
        int max=0;
        
        
        int preSum1=0;
        int preSum2=0;
        
        for(int i=0;i<size1;i++){
            int curr1=a[i];
            
            while(pointer2<size2 && b[pointer2]<curr1){
                preSum2+=b[pointer2];
                
                
                pointer2++;
            }
            
            int curr2=b[Math.min(pointer2,size2-1)];
            
            if(curr1==curr2){
                max+=Math.max(preSum1,preSum2)+curr1;
                
                preSum1=0;
                preSum2=0;
                pointer2++;
            }else{
                preSum1+=curr1;
            }
            
        }
        
        
        while(pointer2<size2){
            preSum2+=b[pointer2];
            pointer2++;
        }
        
        
        max+=Math.max(preSum1,preSum2);
        
        
        
        
        
        return max;
    }
    
    
    
    public int maxPathSum(int[] a, int[] b) {
        int max=0;
        
        if(a.length>=b.length){
        max=maxPath(a,b);
        }else{
            max=maxPath(b,a);
        }
        
        
        // System.out.println(max);
        return max;
    }
}