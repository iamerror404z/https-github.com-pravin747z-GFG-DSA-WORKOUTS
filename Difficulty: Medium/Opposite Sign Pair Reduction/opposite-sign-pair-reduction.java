class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        stack.add(0);
        
        
        for(int i=0;i<arr.length;i++){
           int curr=Math.abs(arr[i]);
           int currSign=arr[i]>=0?1:-1;
           int prev=Math.abs(stack.peek());
           int prevSign=stack.peek()>=0?1:-1;
            
            while(prev!=0 && curr!=0 && prevSign+currSign==0){
                if(curr==prev){
                    stack.pop();
                    curr=0;
                }else if(prev>curr){
                    curr=0;
                }else{
                    stack.pop();
                }
                
                
                prev=Math.abs(stack.peek());
                prevSign=stack.peek()>=0?1:-1;
                
            }
            
            if(curr!=0){
                stack.add(curr*currSign);
            }
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        
        while(stack.size()!=1){
            list.add(stack.pop());
        }
        
        if(list.size()==0){
            return new ArrayList<>();
        }
        
        int size=list.size();
        int mid=size/2;
        
        if(size%2==0){
            mid--;
        }
        
        int start=0;
        int end=size-1;
        
        for(int i=0;i<=mid;i++){
            int temp=list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
            
        }
        
        
        
        
        
        
        
        return list;
        
    }
}