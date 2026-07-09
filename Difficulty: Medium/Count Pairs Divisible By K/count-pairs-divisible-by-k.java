class Solution {
    public int countKdivPairs(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        
        
        int count=0;
        
        for(int i:arr){
            int mod=i%k;
            
            int needed=mod==0?0:k-mod;
            int pairs=map.getOrDefault(needed,0);
            
            count+=pairs;
            
            int prevCount=map.getOrDefault(mod,0);
            map.put(mod,prevCount+1);
            
        }
        
        
        
        return count;
    }
}