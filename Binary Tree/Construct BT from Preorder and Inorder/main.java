class Solution {

    public static TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei)
    {
        if(isi > iei) return null;

        int idx = isi;

        while(inorder[idx] != preorder[psi]) idx++;

        int colse = idx - isi;

        TreeNode node = new TreeNode(preorder[psi]);

        node.left = buildTree(preorder, psi+1, psi+colse, inorder, isi, idx-1);
        node.right = buildTree(preorder, psi+colse+1, pei, inorder, idx+1, iei);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        return buildTree(preorder, 0, n-1, inorder, 0, n-1);
    }
}