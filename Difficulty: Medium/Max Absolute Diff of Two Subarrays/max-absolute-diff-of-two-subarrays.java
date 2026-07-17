class Solution {
    
    
    
    public void buildPrev(int[] arr,int[] prev,int type){
        
        int size=arr.length;
        
        int sumMin=0;
        int sumMax=0;
        
        int min=Integer.MAX_VALUE;
        int  max=Integer.MIN_VALUE;
        
        
        for(int i=1;i<size;i++){
            int curr=arr[i-1];
            sumMin+=curr;
            sumMax+=curr;
            
            int tempMin=Math.min(sumMin,curr);
            int tempMax=Math.max(sumMax,curr);
            
            
            min=Math.min(min,tempMin);
            max=Math.max(max,tempMax);
            
            int res=type==0?min:max;
            
            prev[i]=res;
            
            sumMin=Math.min(0,sumMin);
            sumMax=Math.max(sumMax,0);
        }
        
    }
    
    
    
    
    
    
    public int maxDiffSubArrays(int[] arr) {
        int size=arr.length;
        
        
        
        
        int[] prev=new int[size];
        
        int ans=0;
        
        buildPrev(arr,prev,0);
        
        
        int max=Integer.MIN_VALUE;
        
        
        int sum=0;
        
        
        
        for(int i=size-1;i>=1;i--){
            int curr=arr[i];
            sum+=curr;
            
            int tempMax=Math.max(curr,sum);
            max=Math.max(max,tempMax);
            
            int diff=0;
            
            int diffMin=Math.min(prev[i],max);
            int diffMax=Math.max(prev[i],max);
            
            
            diff=Math.abs(diffMax-diffMin);
            
            ans=Math.max(diff,ans);
            
            
            sum=Math.max(0,sum);
            
        }
        
        
        
        
        
        // System.out.println("sum is : "+ans);
        
        // aprroach 2
        
        
        buildPrev(arr,prev,1);
        
        
        
        // System.out.println(Arrays.toString(prev));
        
        
        int min=Integer.MAX_VALUE;
        sum=0;
        
        
        
        for(int i=size-1;i>=1;i--){
            int curr=arr[i];
            sum+=curr;
            
            int tempMin=Math.min(curr,sum);
            min=Math.min(min,tempMin);
            
            int diff=0;
            
            int diffMin=Math.min(min,prev[i]);
            int diffMax=Math.max(min,prev[i]);
            
             diff=Math.abs(diffMax-diffMin);
             
             ans=Math.max(diff,ans);
            
            // System.out.println("Max is :"+diff);
            
            
            sum=Math.min(0,sum);
        }
        
        
        
        
        
        
        
        
        
        return ans;
    }
}