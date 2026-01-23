class Solution {
    public int maxPeople(int[] arr) {
        int length=arr.length;
        int[] front=new int[length];
        int[] back=new int[length];
        int prev=0;
        
        for(int i=1;i<length;i++){
            if(arr[prev]>arr[i]){
                front[prev]++;
            }else{
                prev=i;
            }
        }
        
        prev=length-1;
        
        for(int i=length-2;i>=0;i--){
            if(arr[prev]>arr[i]){
                back[prev]++;
            }else{
                prev=i;
            }
        }
        
        // System.out.println(Arrays.toString(front));
        // System.out.println(Arrays.toString(back));
        
        int ans=0;
        
        for(int i=0;i<length;i++){
            ans=Math.max(ans,front[i]+back[i]);
        }
        
        
        return ans+1;  
    }
}
