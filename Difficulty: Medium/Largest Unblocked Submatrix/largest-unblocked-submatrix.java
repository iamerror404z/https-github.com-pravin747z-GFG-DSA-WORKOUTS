class Solution {
    
    public void processMap(int[] map){
        int size=map.length;
        
        int prev=size;
        for(int i=size-1;i>=1;i--){
            if(map[i]==i){
                prev=i;
            }else{
                map[i]=prev;
            }
        }
    }
    
    
    public int largestArea(int n, int m, int k, int[][] arr) {
        int[] rowMap=new int[n+1];
        int[] colMap=new int[m+1];
        
        
        for(int i[]:arr){
            int row=i[0];
            int col=i[1];
            
            rowMap[row]=row;
            colMap[col]=col;
        }
        
        processMap(rowMap);
        processMap(colMap);
        
        
        // lets process remaing things 
        
        
        
        int up=0;
        
        
        int max=0;
        
        for(int i=1;i<=n;i++){
            if(rowMap[i]==i){
                up=i;
                continue;
            }
            
            int left=0;
            for(int j=1;j<=m;j++){
                if(colMap[j]==j){
                    left=j;
                    continue;
                }
                
                int down=rowMap[i];
                int right=colMap[j];
                
                int w=right-left-1;
                int h=down-up-1;
                
                max=Math.max(max,w*h);
                
                // System.out.println("w is : "+w+" h is : "+h+" i , j is  "+i+"  "+j);
                // System.out.println(w*h);
                
            }
        }
        
        
        
        
        
        
        // System.out.println(Arrays.toString(rowMap));
        
        // System.out.println(Arrays.toString(colMap));
        
        return max;
    }
}