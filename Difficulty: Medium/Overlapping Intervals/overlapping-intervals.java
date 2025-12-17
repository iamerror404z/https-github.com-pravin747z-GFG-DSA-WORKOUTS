class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
       myComp mycomp=new myComp();
       
       Arrays.sort(arr,mycomp);
       
       int left=0;
       int right=0;
       List<List<Integer>> view =new LinkedList<>();
       
       for(int[] i:arr){
           List<Integer> inner=new LinkedList<>();
           inner.add(i[0]);
           inner.add(i[1]);
           view.add(inner);
       }
       
    //   System.out.println(view);
       
       int size=arr.length;
       
       ArrayList<int[]> list=new ArrayList<>();
       
      while(left<size){
          int start=arr[left][0];
          int end=arr[left][1];
          right=left+1;
          boolean flag=false;
          
        //   System.out.println("left is : "+left);
          
          while(right<size && (end>=arr[right][0] || end>=arr[right][1]
          ||start>=arr[right][0])){
               
              start=Math.min(start,arr[right][0]);
              end=Math.max(end,arr[right][1]);
               
              flag=true;
              right++;
          }
          
        //   System.out.println("right is : "+right+"\n\n");
          
          int[] temp=new int[]{start,end};
          
          list.add(temp);
          
          if(flag){
          left=right; }
          else{
              left++;
          }
      }
       
       
       
       
       return list; 
    }
}



class myComp implements Comparator<int[]>{
    
    @Override
    public int compare(int[] a,int b[]){
        if(a[0]!=b[0]){
            return a[0]-b[0];
        }
        
        
        return a[1]-b[1];
    }
}