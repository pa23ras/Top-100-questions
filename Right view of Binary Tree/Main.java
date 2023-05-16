class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        ArrayList<Integer> ans = new ArrayList<>();

        LinkedList<TreeNode> que = new LinkedList<>();

        if(root==null) return ans;

        que.addLast(root);

        while(que.size()!=0)
        {
            int size = que.size();

            ans.add(que.getFirst().val);

            while(size-->0)
            {
                TreeNode rn = que.removeFirst();

                if(rn.right!=null) que.addLast(rn.right);

                if(rn.left!=null) que.addLast(rn.left);
            }
        }
        return ans;

    }
}