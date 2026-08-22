/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    
    public Node findLCA(Node curr,int p,int q){
        if(curr==null){
            return null;
        }
        
        if(curr.data==p || curr.data==q){
            return curr;
        }
        
        Node left=findLCA(curr.left,p,q);
        Node right=findLCA(curr.right,p,q);
        
        if(left!=null && right!=null){
            return curr;
        }
        
        if(left==null){
            return right;
        }
        
        
        return left;
        
    }
    
    
    public int numOfTurns(Node curr,int free,int p,int q){
        if(curr==null){
            return -1;
        }
        
        if(curr.data==p || curr.data==q){
            return 0;
        }
        
        int left=numOfTurns(curr.left,0,p,q);
        int right=numOfTurns(curr.right,1,p,q);
        
        
        if(Math.max(left,right)==-1){
            return -1;
        }
        
        int dir=left>=0?0:1;
        
        
        return Math.max(left,right)+Math.abs(free-dir);
    }
    
    public int numberOfTurns(Node root, int p, int q) {
        Node lca=findLCA(root,p,q);
        
        int leftSize=numOfTurns(lca.left,0,p,q);
        int rightSize=numOfTurns(lca.right,1,p,q);
        
        leftSize=Math.max(leftSize,0);
        rightSize=Math.max(rightSize,0);
        
        int total=leftSize+rightSize;
        
        if(lca.data!=p &&  lca.data!=q){
            total++;
        }
        
        if(total==0){
            return -1;
        }
        
        // System.out.println("left is : "+leftSize);
        // System.out.println("right is : "+rightSize);
        // System.out.println("res is : "+total);
        
        return total; 
    }
}