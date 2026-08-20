/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    public long dfs(Node curr,long max){
      if(curr==null){

        return Integer.MIN_VALUE;
      }
      
      long currVal=curr.data;
      long left=dfs(curr.left,Math.max(max,currVal));
      long right=dfs(curr.right,Math.max(max,currVal));
      
      

      long res=Math.max(max-curr.data,Math.max(left,right));
    //   System.out.prtinln("Node is : "+currVal);
      
      return res;
    }

    int maxDiff(Node root) {

        return (int)dfs(root,Integer.MIN_VALUE);
        
        // return 147;
    }
}