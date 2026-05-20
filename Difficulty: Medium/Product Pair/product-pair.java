class Solution {
    public boolean isProduct(int[] arr, long target) {
       Map<Integer,Boolean> map=new HashMap<>();
       
        
        
        
      for(int curr:arr){
          
          long needed=0;
          double dNeeded=0;
          
          if(curr!=0){
              needed=target/curr;
              dNeeded=target/(double)curr;
              
             
          }
          
        
          
          if(needed<=Integer.MAX_VALUE && map.getOrDefault((int)needed,false) && dNeeded==needed){
            return true;
          }
          
          map.put(curr,true);
      }
        
        
        
        
        
        
        
        
        return false;
    }
}