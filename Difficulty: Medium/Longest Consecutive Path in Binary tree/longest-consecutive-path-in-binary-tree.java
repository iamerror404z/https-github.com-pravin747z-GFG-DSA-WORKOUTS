/* Structure of Binary Tree Node
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
}*/
class Solution {
    
    public int[] dfs(Node curr,int[] max){
        if(curr==null){
            return new int[2];
        }
        
    
        int[] left=dfs(curr.left,max);
        int[] right=dfs(curr.right,max);
        
        int localMax=0;
        
        if(left[0]==curr.data+1){
            localMax=left[1];
        }
        
        if(right[0]==curr.data+1){
            localMax=Math.max(right[1],localMax);
        }
        
        left[0]=curr.data;
        left[1]=localMax+1;
        
        max[0]=Math.max(max[0],left[1]);
        
        return left;
    }
    
    
    
    
    
    public int longestConsecutive(Node root) {
        int[] max=new int[1];
        
        
        dfs(root,max);
        
        if(max[0]<=1){
            return -1;
        }
        
        
        
        return max[0];
        
    }
}