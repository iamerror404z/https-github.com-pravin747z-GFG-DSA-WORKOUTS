class Solution {
    int minCost(int[] height) {
       int length=height.length;
       int[] dp=new int[length];
       
       if(length==1){
           return 0;
       }
       
       dp[length-2]=Math.abs(height[length-1]-height[length-2]);
       
       for(int i=length-3;i>=0;i--){
          int num1=Math.abs(height[i]-height[i+1])+dp[i+1];
          int num2=Math.abs(height[i]-height[i+2])+dp[i+2];
          
          dp[i]=Math.min(num1,num2);
       }
       
       
       
    //   System.out.println(Arrays.toString(dp));
       
       return dp[0]; 
    }
}