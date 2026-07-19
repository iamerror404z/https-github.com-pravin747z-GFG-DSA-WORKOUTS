class Solution {
    
    
    public void buildTrack(int start,int end,int[] track,int val){
       
       for(int i=start;i<=end;i++){
           
            
            track[i]=val;
        }
        
    }
    
    
    public boolean isPeak(int start,int end,int[] forward
    ,int[] backward,int[] mat){
        
        if(forward[start]>=end){
            return true;
        }
        
        if(backward[end]<=start){
            return true;
        }
        
        int point1=forward[start];
        int point2=backward[end];
        
        
        if(point1>=point2  && mat[point1]==mat[point2]){
            
            return true;
        }
        
        
        
        
        return false;
    }
    
    
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        ArrayList<Boolean>  res=new ArrayList<>();
        
        int size=arr.length;
        
        int[] forward=new int[size];
        
        int prevStart=0;
        
        
        
        for(int i=1;i<size;i++){
            int prevVal=arr[i-1];
            int curr=arr[i];
            
            if(curr<prevVal){
                buildTrack(prevStart,i-1,forward,i-1);
                prevStart=i;
            }
            
            
        }
        
        
        buildTrack(prevStart,size-1,forward,size-1);
        
        int[] backward=new int[size];
        
        
        prevStart=size-1;
        
        
        for(int i=size-2;i>=0;i--){
            int prevVal=arr[i+1];
            int currVal=arr[i];
            
            
            if(currVal<prevVal){
                buildTrack(i+1,prevStart,backward,i+1);
                    prevStart=i;
            }
            
            
            
        }
        
        
        buildTrack(0,prevStart,backward,0);
        
        
       
        // System.out.println(Arrays.toString(forward));
        
        
        // System.out.println(Arrays.toString(backward));
        
        
        for(int i[]:queries){
            int start=i[0];
            int end=i[1];
            
            boolean currRes=isPeak(start,end,forward,backward,arr);
            
            System.out.println(currRes);
            
            // res.add(currRes);
            
        }
        
        
        
        
        
        
        
        return res;
    }
}