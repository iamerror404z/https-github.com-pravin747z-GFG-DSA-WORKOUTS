/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public void preOrder(Node curr,ArrayList<Integer> res){
        if(curr==null){
            return ;
        }
        
        res.add(curr.data);
        
        preOrder(curr.left,res);
        preOrder(curr.right,res);
        
    }
    
    
    
    
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        
        preOrder(root,res);
        
        
        return res;
    }
}