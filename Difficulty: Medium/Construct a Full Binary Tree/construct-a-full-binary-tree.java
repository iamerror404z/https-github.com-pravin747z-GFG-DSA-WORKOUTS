/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */





class Solution {
    
    public Node buildTree(int num,
    int[] pre,int[] mirror,Map<Integer,int[]> map){
        
        // System.out.println("curr num is : "+num);
        Node curr=new Node(num);
        int size=pre.length;
        
        if(!map.containsKey(num)){
            System.out.println("Key not found !"+num);
            return null;
        }
        int[] pos=map.get(num);
        int leftPos=pos[0];
        int rightPos=pos[1];
        
        if(leftPos+1>=size || rightPos+1>=size){
            
            pre[leftPos]=-1;
            mirror[rightPos]=-1;
            return curr;
        }else if(pre[leftPos+1]==-1 || mirror[rightPos+1]==-1){
            pre[leftPos]=-1;
            mirror[rightPos]=-1;
            
            return curr;
        }
        
        Node left=buildTree(pre[leftPos+1],pre,mirror,map);
        Node right=buildTree(mirror[rightPos+1],pre,mirror,map);
        
        
        // left.data+=1;
        // right.data+=1;
        
        curr.left=left;
        curr.right=right;
        
        
        pre[leftPos]=-1;
        mirror[rightPos]=-1;
        
        return curr;
    }
    
    
    
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        int size=pre.length;
        Map<Integer,int[]> map=HashMap.newHashMap(size);
        
        for(int i=0;i<size;i++){
            map.put(preMirror[i],new int[]{0,i});
        }
        
        for(int i=0;i<size;i++){
            int[] curr=map.get(pre[i]);
            curr[0]=i;
        }
        
        
        Node root=buildTree(pre[0],pre,preMirror,map);
      
      
        // System.out.println(root.data);
        
        // for(int i:map.keySet()){
        //     System.out.println("key is : "+i);
        //     System.out.println("loc are : "+Arrays.toString(map.get(i)));
        // }
        
        Node curr=root;
        
        // Node right=curr.right;
        
        // System.out.println(right==null);
        
        
        return root;
    }
}