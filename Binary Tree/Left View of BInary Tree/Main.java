class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      
      ArrayList<Integer> ans = new ArrayList<>();
      
      LinkedList<Node> que = new LinkedList<>();
      
      if(root == null) return ans;
      
      que.addLast(root);
      
      while(que.size()!=0)
      {
          int size = que.size();
          
          ans.add(que.getFirst().data);
          
          while(size-->0)
          {
              Node rn = que.removeFirst();
              
              if(rn.left!=null) que.addLast(rn.left);
              
              if(rn.right!=null) que.addLast(rn.right);
          }
      }
      return ans;
    }
}