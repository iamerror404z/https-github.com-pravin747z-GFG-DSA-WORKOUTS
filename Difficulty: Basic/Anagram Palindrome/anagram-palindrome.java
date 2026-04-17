class Solution {
    boolean canFormPalindrome(String s) {
        int rem=0;
        int[] map=new int[26];
        int length=s.length();
        
        for(int i=0;i<length;i++){
            map[s.charAt(i)-'a']+=1;    
        }
        
        if(length==1){
            return true;
        }
        
        rem-=(length%2);
         for(int i=0;i<26;i++){
            rem+=(map[i]%2);
            
            if(rem>0){
                return false;
            }
        }
        
        
        // System.out.println(Arrays.toString(map));
        
        
        
        return true;
    }
}