public class Q27 {

    public  void mirrorTree(TreeNode root) {
        TreeNode tmp;
        if(root==null) return ;
        tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        if(root.left!=null) mirrorTree(root.left);
        if(root.right!=null) mirrorTree(root.right);
    }
}
