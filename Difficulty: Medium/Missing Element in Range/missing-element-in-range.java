class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        int max=0;
        
        for(int i:arr){
            max=Math.max(max,i);    
        }
        
        max=Math.max(max,high);
        
        int[] track=new int[max+1];
        for(int i:arr){
            track[i]=1;
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=low;i<=high;i++){
            if(track[i]!=1){
                list.add(i);
            }
        }
        
        
        return list;
    }
}