class Solution {
    static boolean canAttend(int[][] arr) {
        myComparator myComp=new myComparator();
        Arrays.sort(arr,myComp);
        boolean result=true;
        
        int index=0;
        
        // for(int i[]:arr){
        //     System.out.print(Arrays.toString(i)+" , ");
        // }
        // System.out.println();
        
        
        while(index<arr.length && result){
            int start=arr[index][0];
            int end=arr[index][1];
            
            if(index+1<arr.length){
                if(end>arr[index+1][0]){
                    result=false;
                }
            }
            
            
            
            index++;
        }
        
        
        
        return result;
    }
    
    
    
}

class myComparator implements Comparator<int[] >{
    @Override
    public int compare(int[] a,int[] b){
       if(a[0]!=b[0]){
           return a[0]-b[0];
       }
       
       return a[1]-b[1]; 
    }
}