public class Q36 {

    public TreeNode convert(TreeNode root) {
        if(root==null) return null;
        backTrack(root);
        while(root.left!=null){
            root = root.left;
        }
        TreeNode p = root;
        while(p!=null){
            System.out.printf("%d\t",p.val);
            p = p.right;
        }
        return root;
    }

    public TreeNode backTrack(TreeNode root) {
        /**
         * 递归函数中中序遍历，
         *
         * */
        if(root.left==null && root.right==null) {
            return root;
        }
        TreeNode left = root.left==null?null:backTrack(root.left);
        TreeNode right = root.right==null?null:backTrack(root.right);
        while(left!=null && left.right!=null){
            left = left.right;
        }
        while(right!=null && right.left!=null){
            right = right.left;
        }
        if(left!=null) {
            left.right = root;
            root.left = left;
        }else{
            root.left = null;
        }
        if(right!=null){
            right.left = root;
            root.right = right;
        }else{
            root.right = null;
        }
        return root;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        Q36 test = new Q36();
        test.convert(root);
    }
}
