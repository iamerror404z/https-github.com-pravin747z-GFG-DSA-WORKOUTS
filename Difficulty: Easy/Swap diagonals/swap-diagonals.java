class Solution {
    public void swapDiagonal(int[][] mat) {
        
        int m=mat.length;
        int n=mat[0].length;
        
        int[] forward=new int[]{0,0};
        int[] backward=new int[]{0,n-1};
        
        while(forward[0]<m && forward[1]<n){
            int temp=mat[forward[0]][forward[1]];
            mat[forward[0]][forward[1]]=mat[backward[0]][backward[1]];
            mat[backward[0]][backward[1]]=temp;
            
            forward[0]++;
            forward[1]++;
            backward[0]++;
            backward[1]--;
        }
        
        
        
    }
}