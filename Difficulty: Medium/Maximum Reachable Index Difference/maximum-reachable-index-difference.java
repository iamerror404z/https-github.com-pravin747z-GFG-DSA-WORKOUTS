class Solution {
    public int maxIndexDifference(String s) {
        int size=s.length();
        int[] map=new int[27];
        
        Arrays.fill(map,-1);
        int max=-1;
        
        for(int i=size-1;i>=0;i--){
            int curr=s.charAt(i)-'a';
            
            if(curr==0){
               int tempDiff=map[1]-i;
               max=Math.max(max,tempDiff);
               max=Math.max(max,0);
                
            }else{
                int tempMax=Math.max(map[curr],map[curr+1]);
                map[curr]=Math.max(i,tempMax);
                
            }
        }
        
        // System.out.println(max);
        return max;
    }
}