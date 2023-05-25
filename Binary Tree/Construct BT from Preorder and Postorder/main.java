class Solution {

    public static TreeNode constructFromPrePost(int[] preorder, int psi, int pei, int[] postorder, int ppsi, int ppei)
    {
        if(psi > pei) return null;

        TreeNode node = new TreeNode(preorder[psi]);

        if(psi == pei) return node;

        int idx = ppsi;

        while(postorder[idx]!= preorder[psi+1])
        {
            idx++;
        }

        int tnel = idx-ppsi+1;

        node.left = constructFromPrePost(preorder, psi+1, psi+tnel, postorder, ppsi, idx);
        node.right = constructFromPrePost(preorder, psi+tnel+1, pei, postorder, idx+1, ppei-1);

        return node;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructFromPrePost(preorder, 0, n-1, postorder, 0, n-1);
    }
}