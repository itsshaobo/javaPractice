import java.util.Stack;

public class Q32 {

    //之字型打印一棵树
    public void printTreeZHI(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    root = stack1.pop();
                    System.out.printf("%d\t",root.val);
                    if(root.left!=null) stack2.push(root.left);
                    if(root.right!=null) stack2.push(root.right);
                }
                System.out.println();
            }
            if(!stack2.isEmpty()){
                while(!stack2.isEmpty()){
                    root = stack2.pop();
                    System.out.printf("%d\t",root.val);
                    if(root.right!=null) stack1.push(root.right);
                    if(root.left!=null) stack1.push(root.left);
                }
                System.out.println();
            }
        }
    }

    public static void main(String [] args) {
        Q32 test = new Q32();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        test.printTreeZHI(root);
    }
}
