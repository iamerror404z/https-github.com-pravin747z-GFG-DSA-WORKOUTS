class Solution {
    
    public int move(int dir,int[] curr,int[] prev,int[][] mat){
        int[] next=curr.clone();
        int currVal=mat[curr[0]][curr[1]];
        int newDir=dir;
        
        if(currVal==0){
            if(dir==0){
                next[1]--;
            }else if(dir==1){
                next[1]++;
            }else if(dir==2){
                next[0]--;
            }else{
                next[0]++;
            }
        }else{
            if(dir==0){
                newDir=2;
                next[0]--;
            }else if(dir==1){
                newDir=3;
                next[0]++;
            }else if(dir==2){
                newDir=1;
                next[1]++;
            }else{
                newDir=0;
                next[1]--;
            }
            
            mat[curr[0]][curr[1]]=0;
        }
        
        
        prev[0]=curr[0];
        prev[1]=curr[1];
        
        
        curr[0]=next[0];
        curr[1]=next[1];
        
        
        return newDir;
    }
    
    
    
    
    public List<Integer> exitPoint(int[][] mat) {
        List<Integer> list=new LinkedList<>();
        
        int rowSize=mat.length;
        int colSize=mat[0].length;
        int[] curr=new int[2];
        int[] prev=new int[2];
        // list.add(0);
        // list.add(0);
        
        int dir=1;
        
        
        while ((curr[0]>=0 && curr[0]<rowSize) && (curr[1]>=0 && curr[1]<colSize)){
            int currVal=mat[curr[0]][curr[1]];
            int newDir=move(dir,curr,prev,mat);
            
            // System.out.println("cur val is : "+currVal);
            // System.out.println("curr is : "+Arrays.toString(curr));
            // System.out.println("new dir is : "+newDir+"\n");
            
            dir=newDir;
        }
        
        
        
        // System.out.println(Arrays.toString(curr));
        
        // System.out.println(Arrays.toString(prev));
        
        list.add(prev[0]);
        list.add(prev[1]);
        
        
        
        
        
        
        
        
        return list;
    }
}