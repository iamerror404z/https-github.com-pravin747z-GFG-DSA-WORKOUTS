/* Structure of linked list node
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
    
    
    public Node method(Node curr,int[] max){
        if(curr==null){
            return null;
        }
        
        Node prev=method(curr.next,max);
        
        if(curr.data<max[0]){
            return prev;
        }
        
        curr.next=prev;
        
        max[0]=curr.data;
        return curr;
        
        
    }
    
    
    
    
    Node compute(Node head) {
        
        Node curr=head;
        int max[]=new int[1];
        
        Node newHead=method(head,max);
        
        
        
        return newHead;
    }
}