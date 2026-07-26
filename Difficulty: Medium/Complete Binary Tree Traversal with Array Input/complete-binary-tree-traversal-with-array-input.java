class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> wrapped=new ArrayList<>();
        
        wrapped.add(new ArrayList(Arrays.asList(arr[0])));
        // adding the first element
    
        
        int start=1;
        int currLevelNodes=1;
        int length=arr.length;
        
        
        
        
        while(start<length){
            currLevelNodes*=2;
            
            int end=Math.min(start+currLevelNodes,length);
            Arrays.sort(arr,start,end);
            
            ArrayList<Integer> inner=new ArrayList<>();
            
            
            for(int i=start;i<end;i++){
                inner.add(arr[i]);
                
            }
            wrapped.add(inner);
            
            
            start=end;
            
            
        }
        
        
        
        
        // wrapped.add(new ArrayList<>());
        
        
        
        
        return wrapped;
    }
    
}