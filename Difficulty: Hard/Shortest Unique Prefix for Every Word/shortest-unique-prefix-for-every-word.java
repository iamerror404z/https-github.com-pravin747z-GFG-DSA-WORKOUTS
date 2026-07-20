class Solution {
    
    public boolean compare(String w1,String w2,int ref1,int ref2,
    int[] track){
        int size=w1.length();
        
        for(int i=0;i<=size;i++){
            if(i==size){
                track[ref1]=size;
                track[ref2]=Math.max(track[ref2],i+1);
                
                return true;
            }
            
            char ch1=w1.charAt(i);
            char ch2=w2.charAt(i);
            
            if(ch1<ch2){
                track[ref1]=Math.max(track[ref1],i+1);
                track[ref2]=Math.max(track[ref2],i+1);
                return true;
            }else if(ch1>ch2){
                track[ref1]=Math.max(track[ref1],i+1);
                track[ref2]=Math.max(track[ref2],i+1);
                return false;
            }
            
            
        }
        
        
        return true;
    }
    
    public void sort(int start,int end,int[] list,String[] words,int[] track){
        int[] temp=new int[end-start+1];
        
        int mid=start+(end-start)/2;
        
        int pointer1=start;
        int pointer2=mid+1;
        
        int resPointer=0;
        
        while(pointer1<=mid && pointer2<=end){
            int ref1=list[pointer1];
            int ref2=list[pointer2];
            
            boolean isLow=compare(words[ref1],words[ref2]
            ,ref1,ref2,track);
            
            if(isLow){
                temp[resPointer]=list[pointer1];
                resPointer++;
                pointer1++;
            }else{
                temp[resPointer]=list[pointer2];
                resPointer++;
                pointer2++;
            }
            
        }
        
        while(pointer1<=mid){
            temp[resPointer]=list[pointer1];
            
            pointer1++;
            resPointer++;
        }
        
        while(pointer2<=end){
            temp[resPointer]=list[pointer2];
            
            pointer2++;
            resPointer++;
        }
        
        // final updation on the list 
        
        // System.out.println(Arrays.toString(temp));
        for(int i=0;i<temp.length;i++){
            list[start+i]=temp[i];
        }
        
        
        
    }
    
    
    
    
    
    

    public void mergeSort(int start,int end,int[] list,String[] words,int[] track){
        if(start>=end){
            return ;
        }
        
        int mid=start+(end-start)/2;
        
        mergeSort(start,mid,list,words,track);
        mergeSort(mid+1,end,list,words,track);
        
        
        
        sort(start,end,list,words,track);
        
    }
    
    
    public ArrayList<String> findPrefixes(String[] arr) {
        int size=arr.length;
        int[] track=new int[size];
        
        if(size==1){
            track[0]=1;
            
            return buildPrefix(track,arr);
        }
        
        int[] list=new int[size];
        for(int i=1;i<size;i++){
            list[i]=i;
        }
        
        
        
        mergeSort(0,size-1,list,arr,track);
        
        
        
        // System.out.println(Arrays.toString(list));
        // System.out.println("prefix is : "+Arrays.toString(track));
        
        
        
        // System.out.println("Hello peter: ");
        return  buildPrefix(track,arr);
    }
    
    
    
    public ArrayList<String> buildPrefix(int[] track,String[] words){
        ArrayList<String> res=new ArrayList<>();
        
        for(int i=0;i<track.length;i++){
            res.add(words[i].substring(0,track[i]));
        }
        
        
        return res;
    }
}