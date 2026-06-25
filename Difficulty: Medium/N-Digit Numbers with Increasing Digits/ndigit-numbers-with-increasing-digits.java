class Solution {
    
    public static void recursion(int num,int currSize,ArrayList<Integer> list,int targetSize){
        if(currSize==targetSize){
            list.add(num);
            
            return ;
        }
        
        int start=(num%10)+1;
        
        int nextElement=num*10;
        currSize++;
        
        int end=9-(targetSize-currSize);
        
        for(int i=start;i<=end;i++){
            recursion(nextElement+i,currSize,list,targetSize);
        }
        
        
        
        
    }
    
    
    
    
    
    public static ArrayList<Integer> increasingNumbers(int n) {
      ArrayList<Integer> list=new ArrayList<>();
      
      if(n>=10){
          return list;
      }
      
      if(n==1){
          list.add(0);
      }
      
      recursion(0,0,list,n);
      
      
      
      
      return   list;
    }
}
