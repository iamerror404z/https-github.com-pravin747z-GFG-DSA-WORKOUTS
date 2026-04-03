class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int rowSize=mat.length;
        int colSize=mat[0].length;
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<colSize;i++){
            int col=i;
            list.add(mat[0][i]);
            col--;
            int row=1;
            
            while(col>=0 && row<rowSize){
                list.add(mat[row][col]);
                col--;
                row++;
            }
        }
        
        
        
        
        for(int i=1;i<rowSize;i++){
            int col=colSize-1;
            int row=i;
            list.add(mat[row][col]);
            
            col--;
            row++;
            
            while(col>=0 && row<rowSize){
                list.add(mat[row][col]);
                col--;
                row++;
            }
            
            
        }
        
        
        
        
        return list;
    }
}
