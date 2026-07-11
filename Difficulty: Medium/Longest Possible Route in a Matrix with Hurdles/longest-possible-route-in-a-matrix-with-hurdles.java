class Solution {
    int[] dest=new int[2];
    
    
    
    public int longestWay(int currX,int currY,int[][] backtrack,int[][] mat){
        if(Math.min(currX,currY)<0  || currX>=mat.length || currY>=mat[0].length){
            return -1;
        }
        
        
        if(backtrack[currX][currY]==1 || mat[currX][currY]==0){
            return -1;
        }
        
        if(currX==dest[0] && currY==dest[1]){
            return 0;
        }
        
        backtrack[currX][currY]=1;
        
        int up=longestWay(currX-1,currY,backtrack,mat);
        int down=longestWay(currX+1,currY,backtrack,mat);
        int left=longestWay(currX,currY-1,backtrack,mat);
        int right=longestWay(currX,currY+1,backtrack,mat);
        
        // System.out.println("up is : "+up);
        // System.out.println("down is :"+down);
        // System.out.println("left is : "+left);
        // System.out.println("right is : "+right);
        // System.out.println("\n");
        
        int max=Math.max(Math.max(up,down),Math.max(left,right));
        
        
        
        backtrack[currX][currY]=0;
        if(max<0){
            return -1;
        }
        
        
        return max+1;
    }
    
    
    
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        dest[0]=xd;
        dest[1]=yd;
        
        if(mat[xs][ys]!=1 || mat[xd][yd]!=1){
            return -1;
        }
        
        int[][] backtrack=new int[mat.length][mat[0].length];
        // dir as follow 
        
        int ans=longestWay(xs,ys,backtrack,mat);
        
        // System.out.println(ans);
        
        
        
        
        return ans; 
    }
}