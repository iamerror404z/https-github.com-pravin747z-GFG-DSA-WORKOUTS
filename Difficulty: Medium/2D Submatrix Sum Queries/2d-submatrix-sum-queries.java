class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int m =mat.length;
        int n=mat[0].length;
        int[][] sum=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j>0){
                    sum[i][j]=mat[i][j]+sum[i][j-1];
                }else{
                    sum[i][j]=mat[i][j];
                }
            }
        }
        
        
        // for(int[] i:sum){
        //     System.out.println(Arrays.toString(i));
        // }
        
        ArrayList<Integer> list=new ArrayList<>();
        
        
        
        
    
        for(int[] i:queries){
            int startr=i[0];
            int startc=i[1];
            int endr=i[2];
            int endc=i[3];
            
            int sumBox=0;
            
            
            for(int j=startr;j<=endr;j++){
                int sub=0;
                int rowSum=0;
                
                if(startc>0){
                    sub=sum[j][startc-1];
                }
                
                rowSum=sum[j][endc]-sub;
            
                sumBox+=rowSum;
                
                
            }
            
            list.add(sumBox);    
            // System.out.println("done\n\n\n");
            sumBox=0;
            // System.out.println(sumBox);
            
        }
        
        // System.out.println(list);
        return list;
    }
}
