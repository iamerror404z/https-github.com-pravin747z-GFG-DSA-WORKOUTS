class Solution {
    public int longestSubseq(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        
        int max=0;
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            
            int inc=map.getOrDefault(curr+1,0);
            
            int dec=map.getOrDefault(curr-1,0);
            
            max=Math.max(max,Math.max(inc,dec)+1);
            
            
            map.put(curr,Math.max(inc,dec)+1);
        }
        
        
        return max;
        
    }
}
