class Solution {
    public int getLastDigit(String a, String b) {
        int aSize=a.length();
        int bSize=b.length();
        
        if(b.equals("0")){
            return 1;
        }
        
        int digit=a.charAt(aSize-1)-'0';
        
        if(digit<=1){
            return digit;
        }
        
        
        
        int[] map=new int[10];
        map[1]=1;
        map[2]=4;
        map[3]=4;
        map[4]=2;
        map[5]=2;
        map[6]=1;
        map[7]=4;
        map[8]=4;
        map[9]=2;
        
        
        
        
        
        int times=map[digit];
        
        long pass=0;
        
        for(int i=bSize;i>=0;i=-15){
            String sub=b.substring(Math.max(0,i-15),i);
            // System.out.println(sub);
            
            long part=Long.parseLong(sub)+pass;
            long newPass=part%times;
            
            if(newPass==0){
                newPass=times;
            }
            
            
            pass=newPass;
        }
        
        
        // System.out.println("pass is : "+pass);
        
        long res=digit;
        
        for(int i=1;i<pass;i++){
            res*=digit;
        }
        
        int unit=(int)(res%10);
        
        
        
        
        return unit; 
    }
}