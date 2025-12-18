class Solution {
    public void sortIt(int[] arr) {
        LinkedList<Integer> odd=new LinkedList<>();
        LinkedList<Integer> even=new LinkedList<>(); 
        
        for(int i:arr){
             if(i%2==0){
                 even.add(i);
             }else{
                 odd.add(i);
             }
        }
        
        Collections.sort(odd);
        Collections.sort(even);
        int pointer=0;
        
        
        while(odd.size()!=0){
            arr[pointer++]=odd.pollLast();
        }
        
        while(even.size()!=0){
            arr[pointer++]=even.poll();
        }
        
        
        
        
    }
}
