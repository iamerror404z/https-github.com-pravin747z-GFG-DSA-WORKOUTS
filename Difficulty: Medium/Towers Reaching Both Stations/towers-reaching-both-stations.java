class Solution {
    
    
    public int[][] processQueue(Queue<int[]> queue,int[][] mat){
        int rowSize=mat.length;
        int colSize=mat[0].length;
        int[][] isVisited=new int[rowSize][colSize];
        
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            
            int row=curr[0];
            int col=curr[1];
            
            int currVal=mat[row][col];
            int dir=curr[2];
            
            
            if(isVisited[row][col]==1){
                continue;
            }
            
            isVisited[row][col]=1;
            
            if(dir!=0 && row-1>=0 && currVal<=mat[row-1][col]){
                queue.add(new int[]{row-1,col,1});
            }
            if(dir!=1 && row+1<rowSize && currVal<=mat[row+1][col]){
                queue.add(new int[]{row+1,col,0});
            }
            if(dir!=2 && col-1>=0 && currVal<=mat[row][col-1]){
                queue.add(new int[]{row,col-1,3});
            }if(dir!=3 && col+1<colSize && currVal<=mat[row][col+1]){
                queue.add(new int[]{row,col+1,2});
            }
            
           
        }
        
        
        return isVisited;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    public int countCoordinates(int[][] mat) {
        int rowSize=mat.length;
        int colSize=mat[0].length;
       
      Queue<int[]> path=new LinkedList<>();
      
    /*
    dir=0==up;
    dir=1=down
    dir=2=lefr
    dir=3=right
    
    
    */ 
    
    for(int i=0;i<colSize;i++){
        path.add(new int[]{0,i,0});
    }
    
    for(int j=1;j<rowSize;j++){
        path.add(new int[]{j,0,2});
    }
    
    int[][] forward=processQueue(path,mat);
    
    for(int i=0;i<colSize;i++){
        path.add(new int[]{rowSize-1,i,1});
    }
    
    for(int i=rowSize-2;i>=0;i--){
        path.add(new int[]{i,colSize-1,3});
    }
      
      
      
    int[][] backward=processQueue(path,mat);
    
    //   System.out.println(path);
     
     int count=0;
     
     for(int i=0;i<rowSize;i++){
         for(int j=0;j<colSize;j++){
             int front=forward[i][j];
             int back=backward[i][j];
             
             if(front==back && front==1){
                 count++;
             }
         }
     }
     
     
     
     
    //  for(int i[]:backward){
    //      System.out.println(Arrays.toString(i));
    //  }
     
    
        
     
        
        
        return count;
    }
}