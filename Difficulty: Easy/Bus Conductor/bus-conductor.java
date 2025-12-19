class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
         int step=0;
         
         Arrays.sort(chairs);
         Arrays.sort(passengers);
         
         for(int i=0;i<chairs.length;i++){
             step+=Math.abs(chairs[i]-passengers[i]);
         }
     
     
     
     
        return step;
    }
}
