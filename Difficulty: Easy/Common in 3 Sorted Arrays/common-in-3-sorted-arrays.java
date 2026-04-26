class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> list=new ArrayList<>();
        
        int index1=0;
        int index2=0;
        
        int size1=a.length;
        int size2=b.length;
        int size3=c.length;
        
        for(int i=0;i<size3;i++){
            while(index1<size1 && a[index1]<c[i]){
                index1++;
            }
            while(index2<size2 && b[index2]<c[i]){
                index2++;
            }
            
            if(index1<size1 && index2<size2 && a[index1]==b[index2] && a[index1]==c[i]){
                list.add(c[i]);
                
                int curr=a[index1];
                
                while(index1<size1 && a[index1]==curr){
                    index1++;
                }
                while(index2<size2 && b[index2]==curr){
                    index2++;
                }
            } 
        }
        
        
        
        return list;
    }
}