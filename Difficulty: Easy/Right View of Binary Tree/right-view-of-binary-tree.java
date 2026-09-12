/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    
    public void traversal(Node curr , int currLevel,ArrayList<Integer> list){
        if(curr==null){
            
            
            return;
        }
        
        if(currLevel==list.size()){
            list.add(curr.data);
        }
        
        traversal(curr.right,currLevel+1,list);
        traversal(curr.left,currLevel+1,list);
        
        
        
        
        
        
    }
    
    
    
    
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        traversal(root,0,list);
        
        return list;
    }
}