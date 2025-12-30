/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    
    public Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        
        
        return prev;
    }
    
    public Node trim(Node head){
        Node curr=head;
        
        while(curr.next!=null && curr!=null && curr.data==0){
            curr=curr.next;
        }
        
        return curr;
    }
    
    
    class Lister{
        Node head=null,tail=null;
        
        public void add(int val){
            Node curr=new Node(val);
            
            if(head==null){
                head=curr;
                return;
            }
            if(tail==null){
                tail=curr;
                head.next=tail;
                return;
            }
            
            tail.next=curr;
            tail=curr;
            
            
        }
        
    }
    
    
    public Node addTwoLists(Node head1, Node head2) {
     head1=reverse(head1);
     head2=reverse(head2);
     
     Node curr1=head1;
     Node curr2=head2;
     int carry=0;
     
     Lister list=new Lister();
     int sum=curr1.data+curr2.data;
     
     if(sum>9){
         carry=sum/10;
         sum=sum%10;
     }
    
     list.add(sum);
     curr1=curr1.next;
     curr2=curr2.next;
     
     
     
     while(curr1!=null && curr2!=null){
          sum=curr1.data+curr2.data+carry;
          
         if(sum>9){
             carry=sum/10;
             sum=sum%10;
         }else{
             carry=0;
         }
            list.add(sum);
            curr1=curr1.next;
            curr2=curr2.next;
         
     }
    
        while(curr1!=null ){
            sum=curr1.data+carry;
            
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }else{
                carry=0;
            }
            list.add(sum);
            curr1=curr1.next;
            
        }
        
        
        while(curr2!=null){
            sum=curr2.data+carry;
            
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }else{
                carry=0;
            }
            list.add(sum);
            curr2=curr2.next;
            
        }
        
        if(carry!=0){
            
            list.add(carry);
            carry=0;
        }
        
        Node head=reverse(list.head);
        head=trim(head);
        
        
     
     
     
     return head;   
    }
}