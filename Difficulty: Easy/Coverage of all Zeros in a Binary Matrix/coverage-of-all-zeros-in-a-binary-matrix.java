class Solution {
    public int findCoverage(int[][] mat) {
        int res=0;
        int rowSize=mat.length;
        int colSize=mat[0].length;
        
        
        
        for(int i=0;i<rowSize;i++){
            int left=0;
            int right=0;
            
            for(int j=0;j<colSize;j++){
             int currLeft=mat[i][j];
             int currRight=mat[i][colSize-(j+1)];
             
             if(currLeft==0){
                 res+=left;
             }else{
                 left=1;
             }
             
             if(currRight==0){
                 res+=right;
             }else{
                 right=1;
             }
            }
        }
        
        
        for(int j=0;j<colSize;j++){
            int up=0;
            int down=0;
            
            for(int i=0;i<rowSize;i++){
                int currUp=mat[i][j];
                int currDown=mat[rowSize-(i+1)][j];
                
                if(currUp==0){
                    res+=up;
                }else{
                    up=1;
                }
                
                if(currDown==0){
                    res+=down;
                }else{
                    down=1;
                }
                
            }
        }
        
        
        
        
        
        
        
        
        return res;
    }
}