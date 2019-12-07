import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q8 {

    //二叉树中序遍历
    public void mid(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() && root != null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // TODO 处理tmp
            if(root.right!=null){
                root = root.right;
            }else{
                root = null;
            }
        }
    }

    public void pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            // TODO 处理root
            if(root.right!=null) stack.push(root.right);
            if(root.left!=null) stack.push(root.left);
        }
    }

    public void post(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() && root != null) {
            while(root!=null){
                stack.push(root);
                root = root.left!=null? root.left : root.right;
            }
            root = stack.pop();
            // TODO 处理root
            if(!stack.isEmpty() && stack.peek().left == root){
                root = stack.peek().right;
            }else{
                root = null;
            }
        }
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            // TODO 处理root
            if(root.left!=null) queue.offer(root.left);
            if(root.right!=null) queue.offer(root.right);
        }
    }


}
