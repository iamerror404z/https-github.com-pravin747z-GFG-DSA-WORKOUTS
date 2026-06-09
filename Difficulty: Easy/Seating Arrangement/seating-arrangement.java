class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int prev=0;
        int size=seats.length;
        
        if(size==1 && seats[0]==0){
            k--;
        }
        
        
        
        for(int i=0;i<size-1;i++){
            int curr=seats[i];
            int next=seats[i+1];
            
            if(curr==1 && (prev==1 || next==1)){
                return false;
            }else if(curr==0 && prev==0 && next==0){
                seats[i]=1;
                k--;
            }
            
            prev=seats[i];
        }
        
        // System.out.println(Arrays.toString(seats));
        
        if(size>=2 &&seats[size-1]==0 && seats[size-2]==0){
            k--;
        }
        
        
        
        
        return k<=0;
    }
}