class Solution {
    
    public long findNum(int start,String s){
        long number=(long)Math.pow(10,16);
        int length=s.length();
        
        while(start<length && s.charAt(start)=='0'){
            start++;
        }
        
        if(start>=length){
            return 0;
        }
        
        long  curr=(long)Math.pow(10,15);
        long prev=curr;
        
        
        for(int i=start;i<length;i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
            long next=curr/10;
            prev=curr;
           
            long digit=curr*(s.charAt(i)-'0');
            number+=digit;
            
            curr=next;
            }else{
                break;
            }            
        }
        
        
        // System.out.println("number is "+number);
        
        long newNum=number-(long)Math.pow(10,16);
        
        
        // System.out.println("newNum is "+newNum);
        // System.out.println("prev is : "+prev);
        
        if(prev<=1){
            return newNum;
        }
       
        return newNum/prev;
    }
    
    
    
    public int myAtoi(String s) {
        long sign=1;
        int index=0;
        
        int length=s.length();
        
        while(index<length && s.charAt(index)==' '){
            index++;
        }
        
        if(index>=length){
            return 0;
        }else if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(s.charAt(index)=='+'){
            index++;
        }
        
        long num=findNum(index,s);
        
        num*=sign;
        
        if(num<Integer.MIN_VALUE){
            return -1*(int)Math.pow(2,31)-1;
        }else if(num>Integer.MAX_VALUE){
            return (int)Math.pow(2,31);
        }
        
        
        
        
        
        return (int)num;
    }
}