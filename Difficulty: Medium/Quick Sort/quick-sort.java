class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low>=high){
            return;
        }
        
        int pivot=partition(arr,low,high);
        
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
        
        
        
        
    }

    private int partition(int[] arr, int low, int high) {
        int pivotElement=arr[high];
        int j=low-1;
        
        for(int i=low;i<high;i++){
            if(arr[i]<=arr[high]){
                j++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        
        arr[high]=arr[j+1];
        arr[j+1]=pivotElement;
        
        
        return j+1;
        
        
        
    }
}