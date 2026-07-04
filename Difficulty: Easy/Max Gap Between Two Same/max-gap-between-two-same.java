class Solution {
    public int maxCharGap(String s) {
        int max=-1;
        int[] map=new int[26];
        int size=s.length();
        
        Arrays.fill(map,size);
        
        for(int i=0;i<size;i++){
            char curr=s.charAt(i);
            int tempMax=i-map[curr-'a']-1;
            
            max=Math.max(max,tempMax);
            
            map[curr-'a']=Math.min(i,map[curr-'a']);
        }
        
        
        
        return max;
    }
}