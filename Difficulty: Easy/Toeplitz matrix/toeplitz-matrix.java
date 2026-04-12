class Solution {
    public boolean isToeplitz(int[][] mat) {
        int rowSize=mat.length;
        int colSize=mat[0].length;
        
        for(int i=1;i<rowSize;i++){
            for(int j=1;j<colSize;j++){
                if(mat[i][j]!=mat[i-1][j-1]){
                    return false;
                }
            }
        }
        
        return true;
    }
}