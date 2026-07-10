class Solution {
    public int getCount(int n) {
     int count=0;
     
     int pointer=0;
     int sum=0;
     
     if(n<=1){
         return 0;
     }
     
     for(int i=1;i<=n;i++){
         int curr=i;
         int limit=i-1;
         
         sum+=i;
         
         while(pointer<limit && sum>n){
             sum-=pointer;
             pointer++;
         }
         
         if(sum==n){
             count++;
         }else if(sum>n){
             return count;
         }
         
     }
     
     
     
     
     
     return count;
    }
}