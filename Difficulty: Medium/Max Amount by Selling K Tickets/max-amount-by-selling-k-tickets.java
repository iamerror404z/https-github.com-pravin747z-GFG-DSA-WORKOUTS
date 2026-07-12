class Solution {
    
    
    public int maxValue(int[] pointer,int[] map,int[] mat){
        int size=map.length;
        int curr=pointer[0];
        int end=pointer[1];
        int next=curr-1>=0?mat[curr-1]:-1;
        // System.out.println("intit curr : "+curr);
        
        // rework needs to be done choosing the max
        
         int currVal=mat[curr];
        int endVal=mat[end];
        int nextVal=next;
        
        if(currVal>=Math.max(nextVal,endVal)){
            // fine let the currVal be as it is 
        }else if(nextVal>currVal && nextVal>=endVal){
            curr--;
        }else if(endVal>Math.max(currVal,nextVal)){
            curr=end;
        }
        
        // System.out.println("curr fixed later "+curr);
        // 
        
        int res=mat[curr];
        
        map[curr]--;
        
        if(map[curr]==-1){
            mat[curr]=-1;
            pointer[0]=curr-1;
            pointer[1]=curr-1;
        }else{
            mat[curr]--;
            pointer[0]=curr;
        }
        
        
        
        
        // System.out.println(Arrays.toString(mat));
        return res;
    }
    
    
    
    
    
    public int maxAmount(int[] arr, int k) {
        int size=arr.length;
        final int mod=(int)Math.pow(10,9)+7;
        int res=0;
        
        
        
        int[] map=new int[size];
        Arrays.sort(arr);
        Arrays.fill(map,k-1);
        
        // System.out.println(Arrays.toString(arr));
        
        
        int[] pointer=new int[]{size-1,size-1};
        
        for(int i=0;i<k && map[0]!=-1;i++){
            int tempRes=maxValue(pointer,map,arr);
            if(tempRes<=0){
                return res;
            }
            long temp=((long)(tempRes))+res;
            
            
            // System.out.println(tempRes);
            res=(int)(temp%mod);
        }
        
        // System.out.println(res);
        
        
        
        return res;
    }
}