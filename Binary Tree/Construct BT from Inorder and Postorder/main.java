class Solution {

    public static TreeNode buildTree(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei)
    {
        if(isi > iei) return null;

        int idx = isi;

        while(inorder[idx] != postorder[pei]) idx++;

        int tnel = idx - isi;

        TreeNode node = new TreeNode(postorder[pei]);

        node.left = buildTree(inorder, isi, idx-1, postorder, psi, psi+tnel-1);
        node.right = buildTree(inorder, idx+1, iei, postorder, psi+tnel, pei-1);

        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree(inorder, 0, n-1, postorder, 0, n-1);
    }
}