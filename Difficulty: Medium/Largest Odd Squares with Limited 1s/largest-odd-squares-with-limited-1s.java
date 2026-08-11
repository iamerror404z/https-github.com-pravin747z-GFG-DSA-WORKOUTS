class Solution {
    /**
     * intially failed to understand the pattern 
     * 
    
    */
    
    
    
    
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int rowSize=mat.length;
        int colSize=mat[0].length;
        
        
        // we are apllying an sentinel row and cols to avoid any issues on the boundry
        int[][] prefixSum=new int[rowSize+1][colSize+1];
        
        for(int i=0;i<rowSize;i++){
            int colSum=0;
            
            for(int j=0;j<colSize;j++){
                int curr=mat[i][j];
                
                int up=prefixSum[i][j+1];
                
                prefixSum[i+1][j+1]=curr+colSum+up;
                
                colSum+=curr;
            }
        }
        
        // System.out.println("prefix arr is : ");
        
        // for(int i[]:prefixSum){
        
        // System.out.println(Arrays.toString(i));}
        
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int curr[]:queries){
            int r=curr[0];
            int c=curr[1];
            
            if(mat[r][c]>k){
                
                res.add(-1);
                continue;
            }
            
            
            int low=0;
            
            int boundary=Math.min(Math.min(r,c),Math.min(rowSize-1-r,colSize-1-c));
            int high=boundary;
            
            // System.out.println("boundary is : "+boundary);
            
            int best=0;
            
            while(low<=high){
                int mid=low+(high-low)/2;
                
                int r0=r-mid+1;
                int c0=c-mid+1;
                
                int r1=r+mid+1;
                int c1=c+mid+1;
            
            
            int leftSub=prefixSum[r1][c0-1];
            int topSub=prefixSum[r0-1][c1]-prefixSum[r0-1][c0-1];
            
            int sum=prefixSum[r1][c1]-(leftSub+topSub);
            
            
            // System.out.println("sum is : "+sum);
            // System.out.println("mid is :  "+mid);
                
                if(sum<=k){
                    best=r1-r0+1;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
                
                
                
            }
            
            res.add(best);
            
            
            
        }
        
        
        
        
        
        
        
        return res;
    }
}