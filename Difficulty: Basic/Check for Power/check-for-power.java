class Solution {
    public boolean isPower(int x, int y) {
        double quotient=y;
    
        if(x==1 && y!=1){
            return false;
        }
        
        double num=(double)y;
        double pow=(double)x;
        
        while(num!=1){
            quotient=num/pow;
            
            if((int)quotient!=quotient){
                return false;
            }
            num=quotient;
        }
        
        return true;
    }
}