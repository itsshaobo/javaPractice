public class Q28 {

    public boolean isSymmetrical(TreeNode root){
        if(root==null) return true;
        return testSub(root.left, root.right);

    }

    public boolean testSub(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) {
            return true;
        }
        if(t1!=null && t2!=null && t1.val == t2.val){
            if(testSub(t1.left, t2.right) && testSub(t1.right, t2.left)){
                return true;
            }
        }
        return false;
    }

}
