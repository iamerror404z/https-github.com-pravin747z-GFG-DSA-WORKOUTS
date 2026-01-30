class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        Queue<Integer> first=new LinkedList<>();
        Queue<Integer> second=new LinkedList<>();
        
        int size=q.size();
        
        
        for(int i=0;i<size/2;i++){
            first.add(q.poll());
        }
        
        for(int i=0;i<size/2;i++){
            second.add(q.poll());
        }
        
        for(int i=0;i<size/2;i++){
            q.add(first.poll());
            q.add(second.poll());
        }
        
        
        
    }
}
