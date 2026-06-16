class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> list=new ArrayList<>();
        
        int size=queries.length;
        int xor=0;
        
        for(int i=size-1;i>=0;i--){
            if(queries[i][0]==1){
                xor=xor^queries[i][1];
            }else{
                list.add(queries[i][1]^xor);
            }
        }
        
        list.add(0^xor);
        
        Collections.sort(list);
        
        
        // System.out.println(list);
        
        return list;
    }
}