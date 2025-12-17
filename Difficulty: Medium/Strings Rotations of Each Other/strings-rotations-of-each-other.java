class Solution {
    public int[] buildLCP(String s){
        int length=s.length();
        int i=0;
        int j=1;
        int[] LCP=new int[length];
        while(i<length && j<length){
            if(s.charAt(i)==s.charAt(j)){
                LCP[j]=i+1;
                i++;
                j++;
                
            }else{
                i=LCP[Math.max(0,i-1)];
                j++;
            }
        }
        
        
        return LCP;
    }
    public boolean areRotations(String s1, String s2) {
        int[] LCP=buildLCP(s2);
        int i=0;
        int j=0;
        
        String word=s1+s1.substring(0,s1.length()-1);
        
        
        while(i<s2.length() && j<word.length()){
            if(s2.charAt(i)==word.charAt(j)){
                i++;
                j++;
            }else if(i-1>=0){
                i=LCP[i-1];
            }else{
                j++;
            }
        }
        
        
        
        
        
        
        return i==s2.length();
    }
}