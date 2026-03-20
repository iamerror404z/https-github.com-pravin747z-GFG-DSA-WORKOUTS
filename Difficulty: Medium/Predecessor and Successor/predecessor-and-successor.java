/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    
    public void min(Node curr,int key,Node[] ans){
        if(curr==null){
            return;
        }
        
        if(curr.data>=key){
            min(curr.left,key,ans);
        }else{
            min(curr.right,key,ans);
        }
        
        
        if(curr.data<key && ans[0].data<curr.data){
            ans[0]=curr;
        }
        
        
        
    }
    
    
    public void max(Node curr,int key,Node ans[]){
        if(curr==null){
            return;
        }
        
        if(curr.data<=key){
            max(curr.right,key,ans);
        }else{
            max(curr.left,key,ans);
        }
        
        if(curr.data>key && curr.data<ans[1].data){
            ans[1]=curr;
        }
    }
    
    
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
     
     ArrayList<Node> answer=new ArrayList<>();
     Node[] ans=new Node[2];
     
     ans[0]=new Node(-1);
     ans[1]=new Node(Integer.MAX_VALUE);
     
     min(root,key,ans);
     max(root,key,ans);
     
     if(ans[1].data==Integer.MAX_VALUE){
         ans[1]=new Node(-1);
     }
     
     answer.add(ans[0]);
     answer.add(ans[1]);
     
     return answer;
    }
}