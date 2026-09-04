class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int size=arr.size();
        
        
        int currWindow=0;
        
        for(int i=0;i<m;i++){
                currWindow+=arr.get(i);
            
        }
        
        int max=currWindow;
        
        int pointer=0;
        
        
        for(int i=m;i<2*size;i++){
            int curr=arr.get(i%size);
            int sub=arr.get(pointer);
            
            currWindow=currWindow-sub+curr;
            max=Math.max(currWindow,max);
            pointer++;
            pointer=pointer%size;
        }
        
        
        return max; 
    }
}