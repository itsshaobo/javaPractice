import java.util.LinkedList;
import java.util.Queue;

public class Q26 {

    //事实上考察的是树的遍历
    public boolean hasSubtree(TreeNode A, TreeNode B) {
        /**
         * 1. 第一步要找出A中所有值为B.val的节点。 层次遍历
         * 2. 对于每一个这种节点，判断是否与B有相同的结构 层次遍历
         * */
        if(B==null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(A);
        TreeNode tmp;
        while(!queue.isEmpty()) {
            tmp = queue.poll();
            if(tmp.val==B.val){
                if(isSubtree(tmp, B)){
                    return true;
                }
            }
            if(tmp.left!=null) queue.offer(tmp.left);
            if(tmp.right!=null) queue.offer(tmp.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode B){
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);
        queue2.offer(B);
        while(!queue2.isEmpty()){
            root = queue1.poll();
            B = queue2.poll();
            if(B.left!=null) {
                if(root.left!=null && B.left.val == root.left.val) {
                    queue1.offer(root.left);
                    queue2.offer(B.left);
                }else{
                    return false;
                }
            }
            if(B.right!=null){
                if(root.right!=null && B.right.val == root.left.val){
                    queue1.offer(root.right);
                    queue2.offer(B.right);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
