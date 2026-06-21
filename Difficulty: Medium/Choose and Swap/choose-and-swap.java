class Solution {
    
    public char min(char ch1,char ch2){
        if(ch1<=ch2){
            return ch1;
        }
        
        return ch2;
    }
    
    public String chooseSwap(String s) {
        StringBuilder sb=new StringBuilder();
        int[] map=new int[26];
        int size=s.length();
        
        
        for(int i=size-1;i>=0;i--){
            char curr=s.charAt(i);
            map[curr-'a']=i;
        }
        
        
        
        // System.out.println(Arrays.toString(map));
        
        char[] swap=new char[2];
        
        swap[0]='.';
        swap[1]='.';
        
        char minPrev='z';
        
        
        for(int i=size-1;i>=0;i--){
            char curr=s.charAt(i);
            
            if(curr>minPrev){
                swap[0]=curr;
                swap[1]=minPrev;
            }
            
            
            if(i==map[curr-'a']){
                minPrev=min(minPrev,curr);
            }
        }
        
        if(swap[0]=='.'){
            return s;
        }
        
        
        for(int i=0;i<size;i++){
            char curr=s.charAt(i);
            
            if(curr==swap[0]){
                sb.append(swap[1]);
            }else if(curr==swap[1]){
                sb.append(swap[0]);
            }else{
                sb.append(curr);
            }
        }
        
        
        
        // System.out.println(sb.toString());
        
        
        
        
        
        return sb.toString();
    }
}