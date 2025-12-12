class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        ArrayList<ArrayList<Integer>> wrapped=new ArrayList<>();
        
        for(int i=0;i<m;i++){
            ArrayList<Integer> inner=new ArrayList<>(Collections.nCopies(n,0));
            wrapped.add(inner);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                wrapped.get(j).set(i,mat[i][j]);
            }
        }
        
        // System.out.println(wrapped);
        return wrapped;
        
    }
}