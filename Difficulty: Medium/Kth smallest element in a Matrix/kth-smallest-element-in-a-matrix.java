class Solution {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> list=new LinkedList<>();
        
        for(int [] i:mat){
            for(int j:i){
                list.add(j);
            }
        }
        
        Collections.sort(list);
        
        
        return list.get(k-1);
        
    }
}
