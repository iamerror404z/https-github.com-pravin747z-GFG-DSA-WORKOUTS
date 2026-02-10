class Solution {
    
    public boolean isPossible(int[] arr,int hours,int s){
        int required=0;
        
        for(int i=0;i<arr.length;i++){
            required+=arr[i]/s;
            
            if(arr[i]%s!=0){
                required++;
            }
            
            if(required>hours){
                return false;
            }
        }
        
        return required<=hours;
    }
    
    public int kokoEat(int[] arr, int k) {
        int max=0;
        
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        
        
        int start=1;
        int end=max;
        
        // System.out.println(end);
        
        
        while(start<end){
        int mid=start+(end-start)/2;
        
        // System.out.println(mid);
        
        
        if(isPossible(arr,k,mid)){
            end=mid;
        }else{
            start=mid+1;
        }
        
        }
        
    
        
        
        return end;        
    }
}
