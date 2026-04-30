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
        int mid=low+(high-low)/2;
        int pivotElement=arr[mid];
        int lastIndex=-1;
        // System.out.println("The mid is :"+mid+":  "+arr[mid]);
        
        int j=low-1;
        
        for(int i=low;i<=high;i++){
            
            if(i==mid){
                continue;
            }
            
            if(arr[i]<=arr[mid]){
                if(j+1==mid){
                    j++;
                }
                j++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                lastIndex=i;
            }
        }
        
        if(j>mid){
            arr[mid]=arr[j];
            arr[j]=pivotElement;
            
            return j;
        }
        
        arr[mid]=arr[j+1];
        arr[j+1]=pivotElement;
        
        
        
        return j+1;
        
        
        
    }
}