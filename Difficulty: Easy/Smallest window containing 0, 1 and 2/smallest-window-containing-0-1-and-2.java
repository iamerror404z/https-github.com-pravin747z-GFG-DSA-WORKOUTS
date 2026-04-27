class Solution {
    public int smallestSubstring(String s) {
        int size=s.length();
        int minSize=size*2;
        int map[]=new int[3];
        Arrays.fill(map,-1);
        
        for(int i=0;i<size;i++){
            char curr=s.charAt(i);
            map[curr-'0']=i;
            
            if(map[0]!=-1 && map[1]!=-1 && map[2]!=-1){
                int start=Math.min(map[0],map[1]);
                start=Math.min(start,map[2]);
                
                int end=Math.max(map[0],map[1]);
                end=Math.max(end,map[2]);
                
                minSize=Math.min(minSize,end-start+1);
            }
        }
        
        
        
        
        if(minSize==2*size){
            return -1;
        }
        
        return minSize;
    }
};
