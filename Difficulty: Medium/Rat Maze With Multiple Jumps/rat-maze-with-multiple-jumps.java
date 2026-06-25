class Solution {
    
    
    public int[] process(int row,int col,int[][][] bt,int[][] mat){
        int n=mat.length;
        
        int[] res=new int[3];
        
        int currJump=mat[row][col];
        int limit=Math.min(currJump,n-1);
        
        
        for(int i=1;i<=limit;i++){
            int right=col+i;
            int down=row+i;
            
            if(right<n && bt[row][col+i][0]!=0){
                res[0]=1;
                res[1]=row;
                res[2]=col+i;
                
                return res;
            }else if(down<n && bt[row+i][col][0]!=0){
                res[0]=1;
                res[1]=row+i;
                res[2]=col;
                
                return res;
            }
            
        }
       

        
        return res;
        
    }
    
    
    
    
    
    
    
    public void buildBT(int[][] mat,int[][][] bt){
        int n=mat.length;
        int size=mat.length;
        
        bt[n-1][n-1][0]=1;
        bt[n-1][n-1][1]=n-1;
        bt[n-1][n-1][2]=n-1;
        
        
        
        // first lets build the logic for last row
        
        for(int j=n-2;j>=0;j--){
            int curr=mat[n-1][j];
            
            if(curr==0){
                continue;
            }
            
            int[] res=process(n-1,j,bt,mat);
            
            
            bt[size-1][j][0]=res[0];
            bt[size-1][j][1]=res[1];
            bt[size-1][j][2]=res[2];
            
            
        }
        
        
        
        
        
        
    //     // handling the remaing vales!
        
        
        
     for(int i=size-2;i>=0;i--){
         for(int j=size-1;j>=0;j--){
             int curr=mat[i][j];
             
             if(curr==0){
                 continue;
             }
             
             
            int[] res=process(i,j,bt,mat);
            
           
            
            bt[i][j][0]=res[0];
            bt[i][j][1]=res[1];
            bt[i][j][2]=res[2];
             
         }
         
     }
       
       
     
    }
     
     public ArrayList<ArrayList<Integer>> buildResult(int[][][] bt,int size){
         ArrayList<ArrayList<Integer>> wrapped=new ArrayList<>();
         
         
         if(bt[0][0][0]==0){
             ArrayList<Integer> curr=new ArrayList<>();
             curr.add(-1);
             wrapped.add(curr);
             
             return wrapped;
             
         }
         
         
         
         for(int i=0;i<size;i++){
             ArrayList<Integer> inner=new ArrayList<>(Collections.nCopies(size,0));
             wrapped.add(inner);
            
         }
         
         int row=0;
         int col=0;
         
         
         while(row!=size-1 || col!=size-1){
             wrapped.get(row).set(col,1);
           
                  
        //   System.out.println("row is "+row+" col is : "+col);
        int tempRow=bt[row][col][1];
            int tempCol=bt[row][col][2];
            
            row=tempRow;
            col=tempCol;
          
         }
         
         
         
         
         wrapped.get(size-1).set(size-1,1);
         
         
         
         
         
         return wrapped;
     }
        
        
        
        
    
        
    
    
    
    
    
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n=mat.length;
        int bt[][][]=new int[n][n][3];
        
        /* 0 refers the sum of the path 
           1--> refers the row of the next element
           2-->refers thw col of the next element
           
        */
        
        buildBT(mat,bt);
        
        
        ArrayList<ArrayList<Integer>> res=buildResult(bt,n);
        
        // res.get(0).set(0,147);
        
        
        // System.out.println(bt[0][1][2]);
        
        
        // System.out.println(res);
        
        return res;
    }
}