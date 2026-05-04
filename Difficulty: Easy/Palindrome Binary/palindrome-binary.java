class Solution {
    public boolean isBinaryPalindrome(int n) {
        String s=Integer.toBinaryString(n);
        
        
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-(1+i))){
                return false;
            }
        }
        
        
        
        
        
        
        
        
        return true;
    }
}