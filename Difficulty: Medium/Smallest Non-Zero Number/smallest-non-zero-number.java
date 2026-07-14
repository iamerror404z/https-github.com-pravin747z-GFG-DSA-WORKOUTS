class Solution {
    
    public boolean isPossible(int[] arr,long num){
        
        for(int curr:arr){
            long diff=curr-num;
            
            if(diff<=0){
                diff*=-1;;
            }
            
            // System.out.println("x is : "+num);
            // System.out.println("curr is : "+curr);
            // System.out.println("difff is : "+diff);
            
           
            
            if(num>curr){
                num+=diff;
            }else{
                num-=diff;
            }
            
            if(num>=Integer.MAX_VALUE){
                return true;
            }
            
            if(num<0){
                return false;
            }
            
        }
        
        
        return true;
        
    }
    
    
    
    public int find(int[] arr) {
        int max=0;
        
        for(int i:arr){
            max=Math.max(max,i);
        }
        
        int start=1;
        int end=max;
        
        
        int boundry=max;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            boolean res=isPossible(arr,(long)mid);
            
            
            if(res){
                end=mid-1;
                boundry=mid;
            }else{
                start=mid+1;
            }
        }
        
        
        boolean tempRes=isPossible(arr,602);
        
        // System.out.println(tempRes);
        
        
        return boundry;
    }
}
