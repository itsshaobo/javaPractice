import java.util.Stack;

public class Q34 {

    //找到路径和为excepted
    public void findPath(TreeNode root, int expected){
        if(root!=null && expected-root.val>=0){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            printOne(root, expected-root.val, stack);
        }
    }

    public void printOne(TreeNode root, int expected, Stack<TreeNode> stack) {
        if (root.left == null && root.right == null) {
            if (expected == 0) {
                // TODO 打印序列
                for(TreeNode node:stack){
                    System.out.printf("%d\t", node.val);
                }
                System.out.println();
            }
            return;
        }
        if (root.left != null && expected - root.left.val >= 0) {
            stack.push(root.left);
            printOne(root.left, expected - root.left.val, stack);
            stack.pop();
        }
        if(root.right!=null && expected-root.right.val >=0){
            stack.push(root.right);
            printOne(root.right, expected-root.right.val, stack);
            stack.pop();
        }
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        Q34 test = new Q34();
        test.findPath(root, 8);
    }
}
