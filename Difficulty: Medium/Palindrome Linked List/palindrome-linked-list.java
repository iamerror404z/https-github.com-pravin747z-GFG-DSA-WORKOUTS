/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/




class Solution {
    
    public Node middle(Node head){
        Node slow=head;
        Node fast=head.next;
        
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    
        
    public void checking(Node ending,Node[] starting,boolean[] results){
        if(ending==null){
            return;
        }
        checking(ending.next,starting,results);
        results[0]=results[0] && (starting[0].data==ending.data);
        
        starting[0]=starting[0].next;
        
        
    }
    
    
    
    public boolean isPalindrome(Node head) {
        boolean result[]=new boolean[]{true};
        
        Node[] starting=new Node[]{head};
        Node mid=middle(head);
        checking(mid.next,starting,result);
        // System.out.println(mid.data);
        
        return result[0];
    }
}