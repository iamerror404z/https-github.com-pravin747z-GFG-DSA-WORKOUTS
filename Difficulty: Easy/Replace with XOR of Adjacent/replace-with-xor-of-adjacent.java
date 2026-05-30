class Solution {
    public void replaceElements(int[] arr) {
        int prev=arr[0];
        arr[0]=arr[0]^arr[1];
        
        for(int i=1;i<arr.length-1;i++){
            int temp=arr[i];
            arr[i]=prev^arr[i+1];
            prev=temp;
        }
        
        arr[arr.length-1]^=prev;
        
        
        
        
    }
}