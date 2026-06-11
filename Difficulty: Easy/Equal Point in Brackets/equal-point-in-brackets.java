class Solution {
    public int findIndex(String s) {
        int size=s.length();
        
        int[] mapFront=new int[size];
        int[] mapBack=new int[size];
        
        int backPos=size-1;
        
        if(s.charAt(0)=='('){
            mapFront[0]++;
        }
        
        
        if(s.charAt(backPos)==')'){
            mapBack[backPos]++;
        }
        
        for(int i=1;i<size-1;i++){
            char currF=s.charAt(i);
            char currB=s.charAt(backPos-i);
            mapFront[i]=mapFront[i-1];
            int back=backPos-i;
            mapBack[back]=mapBack[back+1];
            
            if(currF=='('){
                mapFront[i]++;
            }
            if(currB==')'){
                mapBack[back]++;
            }
        }
        
        
        
        if(size>1){
            mapFront[size-1]=mapFront[size-2];
            mapBack[0]=mapBack[1];
            
            if(s.charAt(size-1)=='('){
                mapFront[size-1]++;
            }
            
            if(s.charAt(0)==')'){
                mapBack[0]++;
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        // System.out.println(Arrays.toString(mapFront));
        // System.out.println(Arrays.toString(mapBack));
        
        
        if(mapBack[0]==size){
            return size;
        }
        
        
        if(mapFront[size-1]==size){
            return 0;
        }
        
        
        for(int i=1;i<size;i++){
            int front=mapFront[i-1];
            int back=mapBack[i];
            
            if(front==back){
                return i;
            }
        }
        
        
        
        
        return size;
    }
}