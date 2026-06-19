class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        
        int left=0;
        
        int sum=arr[0];
        int size=arr.length;
        
        list.add(0);
        
        
        for(int i=1;i<size;i++){
            int curr=arr[i];
            sum+=curr;
            int mid=i/2;
            
            int leftRequired=(mid*arr[mid])-left;
            int right=sum-arr[mid]-left;
            int rightRequired=right-(arr[mid]*(i-mid));
            
            // System.out.println("index is : "+i);
            // System.out.println("left is : "+leftRequired);
            // System.out.println("right is : "+rightRequired);
            
            int currRequired=leftRequired+rightRequired;
            
            
            list.add(currRequired);
            
        
            if(i%2==1){
                left+=arr[mid];
            }
            
            
    
            
            
            
        }
        
        
        
        
        
        return list;
    }
}