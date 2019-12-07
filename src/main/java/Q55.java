public class Q55 {

    public int depthOfTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int leftDepth = depthOfTree(root.left);
        int rightDepth = depthOfTree(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int numOfLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + numOfLeaves(root.left) + numOfLeaves(root.right);
    }

    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        //
        visitTree(root);
        return flag;
    }

    public int visitTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth = depthOfTree(root.left);
        int rightDepth = depthOfTree(root.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            flag = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
