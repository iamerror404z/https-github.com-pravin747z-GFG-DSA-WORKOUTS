class Solution {
    public int professionCode(int currLevel,int currPos,int flag,int targetLevel,int targetPos)
    {   
        // System.out.println("curr level is :"+currLevel+"        curr pos is :"+currPos);
        
        if(currLevel==targetLevel && currPos==targetPos){
            return flag;
        }
        
        // else if(currLevel==targetLevel){
        //     // System.out.println(" curr pos is ddd: "+currPos);
        // }else if(currLevel>targetLevel){
        //     return -1;
        // }
        
        int capacity=(int)Math.pow(2,targetLevel-currLevel)/2;
        
        
        
        int newPos=(currPos-1)*2;
        
        currPos+=newPos;
        // System.out.println(capacity);
        
        
        currLevel++;
        if(targetPos<=capacity){
            return professionCode(currLevel,newPos+1,flag,targetLevel,targetPos);
        }
        
        
        
        return professionCode(currLevel,1,Math.abs(flag-1),targetLevel,targetPos-capacity);
    }
    
    
    
    
    
    public String profession(int level, int pos) {
        String[] op=new String[]{"Engineer","Doctor"};
        int res=professionCode(1,1,0,Math.min(32,level),pos);
        
        // System.out.println(res);
  
        
        
        
        return op[res];
    }
}