import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 前序序列化， 遇到 null 就在字符串上加上 "#,"
        StringBuffer sb = new StringBuffer();
        preRoot(root, sb);
        String ans = sb.toString();
        ans = ans.substring(0, ans.length()-1);
        return ans;
    }

    public void preRoot(TreeNode root, StringBuffer sb) {
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preRoot(root.left, sb);
        preRoot(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String [] dataList = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(String elem:dataList){
            queue.offer(elem);
        }
        return deHelper(queue);
    }

    public TreeNode deHelper(Queue<String> queue){
        String tmp = queue.poll();
        if(tmp.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(tmp));
        root.left = deHelper(queue);
        root.right = deHelper(queue);
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
        Codec test = new Codec();
        System.out.println(test.serialize(root));
    }
}