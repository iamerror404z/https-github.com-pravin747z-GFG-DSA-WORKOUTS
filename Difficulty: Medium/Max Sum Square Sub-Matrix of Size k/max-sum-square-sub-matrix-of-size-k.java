
class Solution {
     public int[][] buildSum(int[][] mat){
        int n=mat.length;
        
        int[][] sum=new int[n][n];
        
        
        for(int r=0;r<n;r++){
            int slide=0;
            
            for(int c=0;c<n;c++){
                int curr=mat[r][c];
                slide+=curr;
                int up=r-1>=0?sum[r-1][c]:0;
                
                sum[r][c]=slide+up;
                
            }
            
        }
        
        
        return sum;
    }
    
    
    public int subtract(int row,int col,int k,int[][] sum){
        int del=0;
        
        int delUp=0;
        int delRight=0;
        
        if(row-1>=0){
            int end=sum[row-1][col+k];
            int start=0;
            
            if(col-1>=0){
                start=sum[row-1][col-1];
            }
            
            delUp=end-start;
            
        }
        
        if(col-1>=0 ){
            delRight=sum[row+k][col-1];            
        }
        
        
        del=delUp+delRight;
        
        return del;
        
    }
    
    public int sum(int row,int col,int k,int[][] sum){
        
        return sum[row+k][col+k];
    }
    
    
    
    
    public int maximumSum(int[][] mat, int k) {
        int max=Integer.MIN_VALUE;
        int n=mat.length;
        
        
        
        int[][] sum=buildSum(mat);
        
        k--;
        
        // for(int i[]:sum){
        //     System.out.println(Arrays.toString(i));
        // }
        
        // System.out.println("Sum is : "+sum(0,0,2,sum));
        
        
        
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+k<n && j+k<n){
                    int partSum=sum(i,j,k,sum);
                    int toRemove=subtract(i,j,k,sum);
                    int res=partSum-toRemove;
                    
                    max=Math.max(max,res);
                    // System.out.println("row is : "+i+" col is : "+j);
                    // System.out.println("partSum is :"+partSum);
                    // System.out.println("toRemove is :"+toRemove);
                    // System.out.println(res+"\n\n");
                    
                }
            }
        }
        
        
      
       
        
        
        
        
        
        return max;
    }
}