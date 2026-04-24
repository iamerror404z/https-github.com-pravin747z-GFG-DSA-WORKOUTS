class Solution {
    public int visibleBuildings(int arr[]) {
        int count=1;
        int max=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(max<=arr[i]){
                count++;
            }
            
            max=Math.max(max,arr[i]);
        }
        
        
        return count;
    }
}