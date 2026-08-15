class Solution {
    
    public int[] buildNum(int n,int index){
        if(n==0){
            return new int[index];
        }
        
        
        int[] arr=buildNum(n/10,index+1);
        int curr=n%10;
        arr[arr.length-1-index]=curr;
        
        
        return arr;
    }
    
    
    public int[] fixNum(int[] num,int d){
        int length=num.length;
        
        int pos=length;
        int fix=d==9?8:9;
        
        for(int i=0;i<length;i++){
            int curr=num[i];
            
            if(curr==d){
                
                if(d!=0){
                num[i]=curr-1;
                pos=i+1;}
                
                else{
                    num[i-1]--;
                    pos=i;
                }
                
                break;
            }
        }
        
      for(int i=pos;i<length;i++){
          num[i]=fix;
      }
        
        return num;
    }
    
    
    public long arrToNum(int[] num){
        long res=0;
        
        for(int i:num){
            res*=10;
            res+=i;
        }
        
        return res;
    }
    
    
    public int countWithout(int n, int d) {
   
        
      int[] num=buildNum(n,0);
       num=fixNum(num,d);
       long newNum=arrToNum(num);
       
    //   System.out.println("new num is : "+newNum);
       
        //   the new number is know hence we can start the process
        // process it except the last element 
        
        
        long b=newNum;
        long sub=0; //subtract the part
        
        int right=1;
        
        
        while(b>0){
            long curr=b%10;
            
            long left=b/10;
            
            if(curr>d && d!=0){
                left++;
            }
            
            // System.out.println("curr is : "+curr);
            // System.out.println("left is : "+left);
            // System.out.println("right is : "+right);
            // System.out.println("prod is : "+(left*right));
            sub+=(left*right);  
            
            right*=9;
            b/=10;
        }
        
        
        
        
    //   System.out.println(Arrays.toString(num));
    //   System.out.println("sub is : "+sub);
       
       
       return (int)(newNum-sub);
        
    }
}