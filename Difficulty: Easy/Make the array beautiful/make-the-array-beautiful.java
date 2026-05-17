class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        
        Deque<Integer> stack=new LinkedList<>();
        int size=arr.length;
        List<Integer> list=new LinkedList<>();
        
        
        for(int i=0;i<size;i++){
            int curr=arr[i];
            int prev=stack.isEmpty()?curr:stack.peek();
            
            int currSign=curr>=0?1:-1;
            int prevSign=prev>=0?1:-1;
            
            if(currSign+prevSign==0){
                stack.pollLast();
            }else{
                stack.add(curr);
            }
            
            
            
        }
        
        
        // System.out.println()
        
        
        while(!stack.isEmpty()){
            list.add(stack.pollFirst());
        }
        
        
        return list;
    }
}