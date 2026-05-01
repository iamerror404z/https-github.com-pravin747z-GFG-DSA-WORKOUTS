class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(k-1,-1));
        
        int min=arr[0];
        
        for(int i=0;i<k;i++){
            min=Math.min(min,arr[i]);
            minHeap.add(arr[i]);
        }
        
        if(arr.length>=k){
            list.add(minHeap.peek());
        }
        
        
        for(int i=k;i<arr.length;i++){
        
        if(arr[i]>minHeap.peek()){
            minHeap.poll();
            minHeap.add(arr[i]);
        }
        
        list.add(minHeap.peek());
        
            
        }
        
        
        
     
     
     
        return list;   
    }
}