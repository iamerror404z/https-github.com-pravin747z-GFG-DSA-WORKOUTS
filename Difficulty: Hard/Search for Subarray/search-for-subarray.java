class Solution {
    
    
    public int[] computeLPS(int[] b){
        int j=0;
        int size=b.length;
        int[] KMP=new int[size];
        
       for(int i=1;i<size;i++){
            if(b[j]==b[i]){
                j++;
            }else{
                j=Math.max(j-1,0);
                j=KMP[j];
            }
            
            KMP[i]=j;
        }
        
        
        return KMP;
    }
    
    
    
    
    
    public ArrayList<Integer> search(int[] a, int[] b) {
        /* we already tried to tackle this using sliding widow since it is not possible now we
        moving forward with the KMP alogirthim . 
        
        
        for detailaed report you can see the previous code 
        */
        
        int sizeA=a.length;
        int sizeB=b.length;
        
        int[] KMP=computeLPS(b);
        ArrayList<Integer> list=new ArrayList<>();
        
        // building KMP Alogrithin for the substring
        
       
        
        
      int i=0;
      int j=0;
      
      
      while(i<sizeA && j<sizeB){
            if(a[i]==b[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j=KMP[j-1];
                }else{
                    i++;
                }
            }
            
            if(j==sizeB){
                int pos=i-sizeB;
                // System.out.println(pos);
                list.add(pos);
                j=KMP[sizeB-1];
            }
            
            
          
      }
        
        
        
        
        
        
        return list;
    }
}