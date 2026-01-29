class Solution {
    
    public char uniqueChar(Map<Character,Integer> map,Queue<Character> queue){
        if(queue.size()==0){
            return '#';
        }
        
        
        char top=queue.peek();
        
        
        while(map.get(top)>=2 && queue.size()!=0){
            queue.poll();
            
            if(queue.size()!=0){
            top=queue.peek();}
        }
        
        
        return (queue.size()>=1) ?  queue.peek() : '#' ;
    }
    
    public String firstNonRepeating(String s) {
        StringBuilder sb=new StringBuilder();
        Map<Character,Integer> map=new HashMap<>();
        
       
        Queue<Character> queue=new LinkedList<>();
        
        char curr=s.charAt(0);
        sb.append(curr);
        map.put(curr,1);
        queue.add(curr);
        
        for(int i=1;i<s.length();i++){
            curr=s.charAt(i);
            int times=map.getOrDefault(curr,0)+1;
            map.put(curr,times);
            
            if(times==1){
                queue.add(curr);
            }
            
            char unique=uniqueChar(map,queue);
            sb.append(unique);
        }
        
        
        
        
        // System.out.println(sb.toString());
        return sb.toString();
    }
}