/*

intialy failed to identify the pattern 

thought about using binary sorting and binary search 


seen the artciel by gfg , !

preFixSum can be  used here 



*/



class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        int[] preFixSum=new int[n];
        
        
        for(int i=0;i<a.length;i++){
            
            int start=a[i];
            int end=b[i];
            
            int inc=k[i];
            
            preFixSum[start]+=inc;
            
            
            if(end+1<n){
            preFixSum[end+1]-=inc;}
            
        // System.out.println(Arrays.toString(preFixSum));
        
            
        }
        
        int res=0;
        int sum=0;
        
        for(int i:preFixSum){
            sum+=i;
            // System.out.println(sum);
            res=Math.max(res,sum);
        }
        
        
        
        
        return res;
    }
}
