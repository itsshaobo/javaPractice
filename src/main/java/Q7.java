public class Q7 {
    //前序中序 构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subTree(preorder, inorder, 0, inorder.length-1, 0);
    }

    public TreeNode subTree(int [] preorder, int[] inorder, int left, int right, int pos){
        // 左闭右闭区间
        if(left>right) return null;
        TreeNode curNode = new TreeNode(preorder[pos]);
        int tmp = 0;
        for(int i=left;i<right+1;i++){
            if(preorder[pos] == inorder[i]){
                tmp = i;
                break;
            }
        }
        curNode.left = subTree(preorder, inorder, left, tmp-1, pos+1);
        curNode.right = subTree(preorder, inorder, tmp + 1 ,right, pos+tmp-left+1);
        return curNode;
    }
}
