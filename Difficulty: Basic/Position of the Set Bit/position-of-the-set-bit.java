class Solution {
    public int findPosition(int n) {
        int num=1;
        
        
        
        for(int i=1;i<31;i++){
            if(num==n){
                return i;
            }
            num=num<<1;
        }
        
        
        
        
        return -1;
        
    }
}